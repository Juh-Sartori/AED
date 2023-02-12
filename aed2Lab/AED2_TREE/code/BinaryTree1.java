/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarytree1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Juliana e Joao Pedro
 */
public class BinaryTree1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        doTreeSizes(10);
        doTreeSizes(1000);
    }

    static void doTreeSizes(int k) {
        PRNG ourrng = new PRNG();
        Tree treeste = new Tree();
        Tree treeste2 = new Tree();
        Tree treeste3 = new Tree();
        Random rng = new Random();
        int vetknow[] = new int[144];
        int v[] = new int[k];
        int v2[] = new int[v.length];
        int v3[] = new int[v.length];

        System.out.println("--------------------------------I-árvores binárias com valores ordenados(" + k + ")--------------------------------");
        long timestart = System.nanoTime();
        for (int i = 0; i < v.length; i++) {
            treeste.add(i);
        }
        System.out.println("Tempo Insercao:" + (System.nanoTime() - timestart));

        //  System.out.println("--------------------------------ARVORE 1(" + k + ")--------------------------------");
        for (int i = 0; i < 30; i++) {
            int b1;//quantidade maxima de bits 
            do {
                b1 = ourrng.nextInt(144);

            } while (vetknow[b1] == b1);
            vetknow[b1] = b1;

            // System.out.println(i+":");
//            if (treeste.search(b1)) {
//                //System.out.println("O valor "+b1+" foi encontrado na arvore de valores ordenados" );
//                System.out.println(b1 + " Y1");
//            } else {
//                // System.out.println("O valor "+b1+" nao foi encontrado na arvore de valores ordenados");
//                System.out.println(b1 + " N1");
//            }
//            System.out.println("");
        }
        //    System.out.println("");
        int n;
        // vetknow = new boolean[144];
        boolean v2bool[] = new boolean[v.length];
        for (int i = 0; i < v2.length; i++) {
            n = rng.nextInt(v2.length);
            while (v2bool[n]) {
                n = rng.nextInt(v2.length);
            }
            v2[i] = n;
            v2bool[n] = true;
        }

        System.out.println("--------------------------------B-árvores binárias com valores ordenados(" + k + ")--------------------------------");
        double media = 0;
        long timesearch = System.nanoTime();
        long vetTimeArm[] = new long[v2.length];
        for (int i = 0; i < v2.length; i++) {
            timestart = System.nanoTime();
            treeste.search(v2[i]);
            vetTimeArm[i] = System.nanoTime() - timestart;
            media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo Busca " + (System.nanoTime() - timesearch));
        System.out.println("Media: " + (media / vetTimeArm.length));
        System.out.println("Desvio padrao: " + standardDeviation(vetTimeArm));

        System.out.println("--------------------------------I-árvores binárias com valores aleatórios(" + k + ")--------------------------------");
        timestart = System.nanoTime();
        for (int i = 0; i < v2.length; i++) {
            treeste2.add(v2[i]);
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
//            if (treeste2.search(b2)) {
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

        System.out.println("--------------------------------B-árvores binárias com valores aleatórios(" + k + ")--------------------------------");
        media = 0;
        timesearch = System.nanoTime();
        vetTimeArm = new long[v2.length];
        for (int i = 0; i < v2.length; i++) {
            timestart = System.nanoTime();
            treeste2.search(v2[i]);
            vetTimeArm[i] = System.nanoTime() - timestart;
            media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo Busca " + (System.nanoTime() - timesearch));
        System.out.println("Media: " + (media / vetTimeArm.length));
        System.out.println("Desvio padrao: " + standardDeviation(vetTimeArm));

        System.out.println("--------------------------------I-árvores binárias balanceadas(" + k + ")--------------------------------");
        timestart = System.nanoTime();
        for (int i = 0; i < v3.length; i++) {
            treeste3.add(v3[i]);
        }
        System.out.println("Tempo Insercao:" + (System.nanoTime() - timestart));
        //System.out.println("--------------------------------ARVORE 3(" + k + ")--------------------------------");
        vetknow = new int[144];
        for (int i = 0; i < 30; i++) {
            int b3;
            do {

                b3 = ourrng.nextInt(144);

            } while (vetknow[b3] == b3);
            vetknow[b3] = b3;
            // System.out.println(i+":");
//            if (treeste3.search(b3)) {
//                // System.out.println("O valor "+b3+" foi encontrado na arvore balanceada" );
//                System.out.println(b3 + " y3");
//            } else {
//                //System.out.println("O valor "+b3+" nao foi encontrado na arvore balanceada");
//                System.out.println(b3 + " n3");
//            }
//            System.out.println("");
        }
        System.out.println("--------------------------------B-árvores binárias balanceadas(" + k + ")--------------------------------");
        media = 0;
        timesearch = System.nanoTime();
        vetTimeArm = new long[v2.length];
        for (int i = 0; i < v2.length; i++) {
            timestart = System.nanoTime();
            treeste2.search(v2[i]);
            vetTimeArm[i] = System.nanoTime() - timestart;
            media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo Busca " + (System.nanoTime() - timesearch));
        System.out.println("Media: " + (media / vetTimeArm.length));
        System.out.println("Desvio padrao: " + standardDeviation(vetTimeArm));

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

    static double standardDeviation(long v[]) {
        double standard_deviation = calculateSD(v);
        return standard_deviation;
    }

    public static double calculateSD(long v[]) {
        double sum = 0.0, standard_deviation = 0.0;
        int v_size = v.length;
        for (double temp :v) {
            sum += temp;
        }
        double mean = sum / v_size;
        for (double temp : v) {
            standard_deviation += Math.pow(temp - mean, 2);
        }
        return Math.sqrt(standard_deviation / v_size);
    }
}


