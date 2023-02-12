/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trie;
/**
 *
 * @author Juliana e Joao Pedro
 */
public class PRNG {

    private long last;
    private long inc;
    private int count = 0;

    public PRNG() {
        long seed = System.nanoTime();
        this.last = seed | 1;
        inc = seed;
    }

    public int nextInt(int max) {
        if (count == 144) {
            long seed = System.nanoTime();
            this.last = seed | 1;
            inc = seed;
        }
        last ^= (last << 400);
        last ^= (last >>> 700);
        last ^= (last << 100);
        inc += 123456789123456789L;  //num magico(incremento)
        int out = (int) ((last + inc) % max);
        count++; 
        return (out < 0) ? -out : out;
    }
}
