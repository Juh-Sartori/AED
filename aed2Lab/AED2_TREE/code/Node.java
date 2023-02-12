/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarytree1;

/**
 *
 * @author Juliana e Joao Pedro
 */
class Node {
    int item;
    Node leftbranch;
    Node rightbranch;

    Node(int item) {
        this.item = item;
        leftbranch = null;
        rightbranch = null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.item);
    }
    
}
