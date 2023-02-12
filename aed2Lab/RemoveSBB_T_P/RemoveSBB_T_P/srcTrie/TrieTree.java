/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trie;

/**
 *
 * @author julia
 */
public class TrieTree {
    public static class Noh{

        //a posição do vetor simboliza o caractere
        public boolean finishWord;                                              //Indica se o caminho formou uma word
        public Noh vetNOfilhos[];                                               //Possiveis proximos caracteres
        
        //Construtor padrão  
        public Noh(){                                                        
            finishWord = false;
            vetNOfilhos = new Noh[26];                                          //26 qtd de letras do alfabeto

            for(int i = 0; i < 26; i++){                                        //Definindo um valor (Setando) para null
                vetNOfilhos[i] = null;
            }
        }
    }

    private Noh raiz;                                                           //Noh raiz da arvore Trie
    public int qtdNos;
    public String vet[];

    //construtor padrao 
    public TrieTree(int qtdNos){
        raiz = new Noh();
        this.qtdNos = qtdNos;
        vet = new String[(int)(qtdNos * 0.01)];
    }

    // Busca uma palavra na Trie
    public boolean search( String word ){
        
        word = word.toLowerCase();                                              //mudando a palavra para letras minusculas
        
        Noh noAux = this.raiz;

        for(int j = 0; j < word.length(); j++){

            if( noAux.vetNOfilhos[ word.charAt(j) - 'a' ] == null ){            //Nao existe noh correspondente
                return false;
            }
            noAux = noAux.vetNOfilhos[word.charAt(j) - 'a' ];
        }

        if( ( noAux != null ) && ( noAux.finishWord == true ) ){                
            return true;                                                        //foi encontrado o noh
        }

        return false;                                                           //senao encontarr eh falso
    }

    //Insere uma palavra na Trie
    public boolean insert( String word){
        
        word = word.toLowerCase();
        
        if( search(word) == true ) {                                             //Caso em que a palavra ja foi adicionada
            return false;
        }

        Noh noAux = this.raiz;

        for( int i = 0; i < word.length(); i++){

            if( noAux.vetNOfilhos[ word.charAt(i) - 'a'] == null ){             
                noAux.vetNOfilhos[ word.charAt(i) - 'a'] = new Noh();           //add se o noh nao existir
            }
            
            noAux = noAux.vetNOfilhos[ word.charAt(i) - 'a'];  
        } 

        noAux.finishWord = true;

        return true;
    }

    // Remover uma palavra na Trie
    public boolean delete( String word ){
        
        word = word.toLowerCase(); 
        
        if( search(word) == false ){                                           //A palavra nao esta na Trie
            return false;
        }        

        Noh noAux = this.raiz;
        Noh noAuxTerminal = noAux;
        int indiceDepoisDoTerminal = word.charAt(0) - 'a';
        
        for( int j = 0; j < word.length(); j++){

            if( noAux.finishWord == true ){
                noAuxTerminal = noAux;
                indiceDepoisDoTerminal = word.charAt(j) - 'a';
            }
            
            noAux = noAux.vetNOfilhos[ word.charAt(j) - 'a' ];
        }
       
        noAuxTerminal.vetNOfilhos[indiceDepoisDoTerminal] = null; 

        return true;
    }    
}
   

