/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trie;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author julia
 */
public class Trie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        doTreeSizes(1000);
        doTreeSizes(10000);
        //doTreeSizes(1000000);
    }

    static void doTreeSizes(int k) {

        PRNG ourrng = new PRNG();

        TrieTree treeste = new TrieTree(k);

        Random rng = new Random();
        int vetknow[] = new int[144];
        int v[] = new int[k];
        int v2[] = new int[v.length];
        int v3[] = new int[v.length];
        long timestart = System.nanoTime();
        double media = 0;
        long timesearch = System.nanoTime();
        long vetTimeArm[] = new long[v2.length];

        System.out.println("--------------------------------I-arvores Trie(" + k + ")--------------------------------");
        timestart = System.nanoTime();
        for (int i = 0; i < v2.length; i++) {
            makeTrie(treeste);
        }
        System.out.println("Tempo Insercao:" + (System.nanoTime() - timestart));
        //   System.out.println("--------------------------------ARVORE 2(" + k + ")--------------------------------");
        vetknow = new int[144];
        for (int i = 0; i < 30; i++) {
            int b2;

            do {
                b2 = ourrng.nextInt(144);
            } while (vetknow[b2] == b2);
            vetknow[b2] = b2;
            // System.out.println(i+":");
//            if (treeste.search(b2)) {
//                //  System.out.println("O valor "+b2+" foi encontrado na arvore de valores aleatorios" );
//                System.out.println(b2 + " S2");
//            } else {
//                //   System.out.println("O valor "+b2+" nao foi encontrado na arvore de valores aleatorios");
//                System.out.println(b2 + " N2");
//            }
            //        System.out.println("");
        }
        //      System.out.println("");
        for (int i = 0; i < v3.length; i++) {
            v3[i] = i;
        }
        Arrays.sort(v3);
        ArrayToBST(v3);

        System.out.println("--------------------------------B-arvores Trie(" + k + ")--------------------------------");
        media = 0;
        timesearch = System.nanoTime();
        vetTimeArm = new long[v2.length];
        for (int i = 0; i < v2.length; i++) {
            timestart = System.nanoTime();
            searchTrie(treeste);
            vetTimeArm[i] = System.nanoTime() - timestart;
            media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo Busca " + (System.nanoTime() - timesearch));

    }

    static void ArrayToBST(int v[]) {
        sortedArrayToBST(v, 0, v.length, 0);
    }

    static int sortedArrayToBST(int v[], int first, int last, int count) {
        boolean v2[] = new boolean[v.length];
        int middle = (first + last) / 2;
        if (count < v.length && v2[middle] == false) {
            v[count] = middle;
            v2[middle] = true;
            if (middle != first) {
                count = sortedArrayToBST(v, first, middle - 1, count + 1);
            }
            if (middle != last) {
                count = sortedArrayToBST(v, middle + 1, last, count + 1);
            }
            return count;
        }
        return 0;
    }
     static void makeTrie(TrieTree t) {
        String aux;
        for (Integer i = 0; i < t.qtdNos; i++) {
            aux = RandomString(5);
            t.insert(aux);
            if (i < t.vet.length) {
                t.vet[i] = aux;
            }
        }
    }
     static void searchTrie(TrieTree t) {

        //salvar o tempo das 30 buscas
        int temp[] = new int[(int) (t.qtdNos * 0.01)];
        int j = 0;
        while (j < temp.length) {
            int aux = (int) System.nanoTime();
            if (t.search(t.vet[j])) {
                aux = (int) System.nanoTime() - aux;
                temp[j] = aux;
                j++;
            }
        }

    }

     static String RandomString(int i) {
        String Alfabeto;
        StringBuilder builder;

        Alfabeto = "abcdefghijklmnopqrstuvwxyz";

        //create the StringBuffer
        builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {

            // generate numeric
            int myindex = (int) (Alfabeto.length() * Math.random());

            // add the characters
            builder.append(Alfabeto
                    .charAt(myindex));
        }

        return builder.toString();
    }
}


