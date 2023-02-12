/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juliana e João Pedro
 */
public class Main {

    
    public static void main(String[] args) {

        PRNG ale = new PRNG();
        int n = ale.nextInt(1000); //quantidade maxima de bits 
        for (int i = 0; i < 1000; i++) {
            n = ale.nextInt(1000);
           // System.out.println(i+":");
            System.out.println(n);
        }
    }

}
