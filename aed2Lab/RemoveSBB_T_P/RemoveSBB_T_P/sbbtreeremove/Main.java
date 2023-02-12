package sbbtree;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Julia e JP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        doTreeSizes(1000);
        doTreeSizes(10000);
        doTreeSizes(100000);        //estourou a pilha de execucao dojava  
    }

    static void doTreeSizes(int k) {
        PRNG ourrng = new PRNG();
        Arvore treeste = new Arvore();
        Arvore treeste2 = new Arvore();
        Arvore treeste3 = new Arvore();
        Random rng = new Random();
        int vetknow[] = new int[1000];
        int v[] = new int[k];
        int v2[] = new int[v.length];
        int v3[] = new int[v.length];

//        System.out.println("--------------------------------I-árvores binárias com valores ordenados(" + k + ")--------------------------------");
        long timestart = System.nanoTime();
        for (int i = 0; i < v.length; i++) {
            treeste.insert(i);
        }
        //  System.out.println("Tempo Insercao:" + (System.nanoTime() - timestart));

        //  System.out.println("--------------------------------ARVORE 1(" + k + ")--------------------------------");
        for (int i = 0; i < 30; i++) {
            int b1;//quantidade maxima de bits 
            do {
                b1 = ourrng.nextInt(1000);
            } 
            while (vetknow[b1] == b1);
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
//        boolean v2bool[] = new boolean[v.length];
//        for (int i = 0; i < v2.length; i++) {
//            n = rng.nextInt(v2.length);
//            while (v2bool[n]) {
//                n = rng.nextInt(v2.length);
//            }
//            v2[i] = n;
//            v2bool[n] = true;
//        }

        System.out.println("--------------------------------R-arvore SBB com valores ordenados de tamanho(" + k + ")--------------------------------");
        double media = 0;
        long timedelete = System.nanoTime();
//        long vetTimeArm[] = new long[v2.length];
        int conttrue = 0;
        boolean testdelete;
int churrasco = 0;
            timestart = System.nanoTime();
               int batata;
            while (conttrue != (k / 20) && (churrasco < v2.length)) {//50*1000
                batata = rng.nextInt(k);
                testdelete = treeste.delete(batata);
                churrasco++;
                if (testdelete == true) {
                    conttrue++;
                }


            //treeste.search(v2[i]);
            //vetTimeArm[i] = System.nanoTime() - timestart;
            //media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo de Remocao: " + (System.nanoTime() - timedelete));
        //System.out.println("Media: " + (media / vetTimeArm.length));
        // System.out.println("Desvio padrao: " + standardDeviation(vetTimeArm));

//        System.out.println("--------------------------------I-árvores binárias com valores aleatórios(" + k + ")--------------------------------");
        timestart = System.nanoTime();
        for (int i = 0; i < v2.length; i++) {
            treeste2.insert(v2[i]);
        }
        // System.out.println("Tempo Insercao:" + (System.nanoTime() - timestart));
        //   System.out.println("--------------------------------ARVORE 2(" + k + ")--------------------------------");
        vetknow = new int[1000];
        for (int i = 0; i < 30; i++) {
            int b2;

            do {
                b2 = ourrng.nextInt(1000);
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
      System.out.println("--------------------------------R-arvores SBB com valores aleatorios de tamanho(" + k + ")--------------------------------");
        media = 0;
        timedelete = System.nanoTime();
        conttrue = 0;

//        vetTimeArm = new long[v2.length];
              churrasco = 0;
            timestart = System.nanoTime();
             batata= 0;
            while (conttrue != (k / 20) && (churrasco < v2.length)) {//50*1000
                batata = rng.nextInt(k);
                testdelete = treeste2.delete(batata);
                churrasco++;
                if (testdelete == true) {
                    conttrue++;
                }
            
//            treeste2.search(v2[i]);
//            vetTimeArm[i] = System.nanoTime() - timestart;
//            media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo de Remocao: " + (System.nanoTime() - timedelete));
//        System.out.println("--------------------------------I-árvores binárias balanceadas(" + k + ")--------------------------------");
        timestart = System.nanoTime();
        for (int i = 0; i < v3.length; i++) {
            treeste3.insert(v3[i]);
        }
//        System.out.println("Tempo Insercao:" + (System.nanoTime() - timestart));
        //System.out.println("--------------------------------ARVORE 3(" + k + ")--------------------------------");
        vetknow = new int[1000];
        for (int i = 0; i < 30; i++) {
            int b3;
            do {

                b3 = ourrng.nextInt(1000);

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
        System.out.println("--------------------------------R-arvores SBB balanceadas de tamanho (" + k + ")--------------------------------");
        media = 0;
        timedelete = System.nanoTime();
        //vetTimeArm = new long[v2.length];
              churrasco = 0;
            timestart = System.nanoTime();
             batata= 0;
            while (conttrue != (k / 20) && (churrasco < v2.length)) {//50*1000
                batata = rng.nextInt(k);
                testdelete = treeste3.delete(batata);
                churrasco++;
                if (testdelete == true) {
                    conttrue++;
                }
//            treeste2.search(v2[i]);
//            vetTimeArm[i] = System.nanoTime() - timestart;
//            media += vetTimeArm[i]; //media = media + vetTimeArm[i];
        }
        System.out.println("Tempo de Remocao: " + (System.nanoTime() - timedelete));
//        System.out.println("Media: " + (media / vetTimeArm.length));
//        System.out.println("Desvio padrao: " + standardDeviation(vetTimeArm));

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


}
