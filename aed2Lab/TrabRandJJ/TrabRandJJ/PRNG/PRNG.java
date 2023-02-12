
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author João Pedro e Juliana
 */
public class PRNG {

    private long last;
    private long inc;

    public PRNG() {
        long seed = System.nanoTime();
        this.last = seed | 1;
        inc = seed;
    }

    public int nextInt(int max) {
        last ^= (last << 400);
        last ^= (last >>> 700);
        last ^= (last << 100);
        inc += 123456789123456789L;  //num magico(incremento)
        int out = (int) ((last + inc) % max);
        return (out < 0) ? -out : out;
    }
}
////////////////////////(ABAIXO)CODIGOS DE EXEMPLO, usado como referencias////////////////////////
    //Semente = a base inicial para a sequência numérica.
    // Java implementation of the above approach
//    public static void main(String[] args) {
//        long seed = 1;
//        long firstseed = seed;
//        do {
//            System.out.println(seed);
//            seed = xorrnd(seed);
//        } while (seed != 35651601);
//        System.out.println(seed);
//    }
//
//    static long xorrnd(long seed) {
//        int a = 21;
//        int b = 35;
//        int c = 4;
//        int nbits = 30;
//        seed ^= (seed << a);
//        seed ^= (seed >>> b);
//        seed ^= (seed << c);
//        seed &= ((1L << nbits) - 1);//1L tamanho long
//        return (int) seed;
//    }


//    public static void main(String[] args) {
//        
//        int semente = 1;
//        int i =0;
//        for(i=0; i < 10 ;i++){
//            
//            System.out.println(randomj(1));
//        }
//    }
//    
//    public double randomj(int semente){
//        int a, b, c, m;
//        a = 13;
//        b = 17;
//        c = 5;
//        m = 1073741824;
//
//        semente = (semente) ^ ((semente) << a);
//        semente = (semente) ^ ((semente) >> b);
//        semente = (semente) ^ ((semente) << c);
//
//        if (semente < 0){
//            
//            semente = (semente + m) +m;
//        }
//
//        return (((double) semente) / (2f* ((double) m)));
//    }
//}      
//    
//    
////    ABAIXO(testes fracassados)
////    public void geraNumPseudoAleat(){
////        
////    }
////
////     public static void main(String[] args) {
////        short a = 32700;
////        
////        for(int i =0; i<100 ;i++){
////            a+=1;
////        }
////        System.out.println(a);
////    }
////    public static void main(String[] args) {
////        Random gera = new Random();
////        
////        for(int i=0; i<10 ;i++){
////            System.out.println(gera.nextInt());
////            System.out.println("");
////        }
////    }
////      //Semente = a base inicial para a sequência numérica.
////    public int semente(int sem){
////        if(sem == 0){
////            return 0;
////        }
////        
////        else{
////            //talvez o while da folha tenha q ficar aq
////           for(int n =0; n< sem /*2147483647*/ ;n++){
////              
////               n = (a)
////                       /// n = n+1; para o while caso for 
////           }
////        }
////        
////        for(int i=0; i < semente;i++){
////            
////        }
////        return 0;
////    }//   
////    public int semente(int sem){
////        if(sem == 0){
////            return 0;
////        }
////        
////        else{
////            //talvez o while da folha tenha q ficar aq
////           for(int n =0; n< sem /*2147483647*/ ;n++){
////              
////               n = (a)
////                       /// n = n+1; para o while caso for 
////           }
////        }
////        
////        for(int i=0; i < semente;i++){
////            
////        }
////        return 0;
////    }

