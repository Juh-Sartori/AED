/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/class1s/Main.java to edit this template
 */
package patriciatrieaed2;

/**
 *
 * @author Joao Pedro
 */
public class PaTrieciaTree {
 private static abstract class PatNode {
    }

    private static class PatNodeInt extends PatNode {

        int index;
        PatNode left, right;
    }

    private static class PatEndNode extends PatNode {

        int item; 
    }

    private PatNode root;
    private int nbitsitem;
    public int nodeAmount; 
    
    public void PatriciaTree(int nbitsitem, int nodeAmount) {
        this.root = null;
        this.nbitsitem = nbitsitem;
        this.nodeAmount = nodeAmount;
        
    }

    private int bit(int i, int k) {
        if (i == 0) {
            return 0;
        }
        int c = (int) k;
        for (int j = 1; j <= this.nbitsitem - i; j++) {
            c = c / 2;
        }
        return c % 2;
    }

    // @{\it Verifica se p \'e n\'o externo}@
    private boolean isEndNode(PatNode p) {
        Class class1 = p.getClass();
        return class1.getName().equals(PatEndNode.class.getName());
    }

    private PatNode createIntNode(int i, PatNode left, PatNode right) {
        PatNodeInt p = new PatNodeInt();
        p.index = i;
        p.left = left;
        p.right = right;
        return p;
    }

    private PatNode createEndNode(int k) {
        PatEndNode p = new PatEndNode();
        p.item = k;
        return p;
    }

    private boolean search(int k, PatNode t) {
        if (this.isEndNode(t)) {
            PatEndNode aux = (PatEndNode) t;
            if (aux.item == k) {
                return true;
            } else {
                return false;
            }
        } else {
            PatNodeInt aux = (PatNodeInt) t;
            if (this.bit(aux.index, k) == 0) {
                return search(k, aux.left);
            } else {
                return search(k, aux.right);
            }
        }
    }

    private PatNode insertBetween(int k, PatNode t, int i) {
        PatNodeInt aux = null;
        if (!this.isEndNode(t)) {
            aux = (PatNodeInt) t;
        }
        if (this.isEndNode(t) || (i < aux.index)) { // @{\it Cria um novo n\'o externo}@
            PatNode p = this.createEndNode(k);
            if (this.bit(i, k) == 1) {
                return this.createIntNode(i, t, p);
            } else {
                return this.createIntNode(i, p, t);
            }
        } else {
            if (this.bit(aux.index, k) == 1) {
                aux.right = this.insertBetween(k, aux.right, i);
            } else {
                aux.left = this.insertBetween(k, aux.left, i);
            }
            return aux;
        }
    }
    public void insert(int insertItem) {
        
        this.root = this.insert(insertItem, this.root);
    }
    private PatNode insert(int insertItem, PatNode currentNode) {
        if (currentNode == null) {
            return this.createEndNode(insertItem);
        } else {
            PatNode p = currentNode;
            while (!this.isEndNode(p)) {
                PatNodeInt aux = (PatNodeInt) p;
                if (this.bit(aux.index, insertItem) == 1) {
                    p = aux.right;
                } else {
                    p = aux.left;
                }
            }
            PatEndNode aux = (PatEndNode) p;
            int i = 1; // @{\it acha o primeiro bit diferente}@
            while ((i <= this.nbitsitem)
                    && (this.bit(i, insertItem) == this.bit(i, aux.item))) {
                i++;
            }
            if (i > this.nbitsitem) {
                return currentNode;
            } else {
                return this.insertBetween(insertItem, currentNode, i);
            }
        }
    }

    private void central(PatNode parentNode, PatNode next, String msg) {
        if (next != null) {
            if (!this.isEndNode(next)) {
                PatNodeInt aux = (PatNodeInt) next;
                central(next, aux.left, "left");
                if (parentNode != null) {
                    System.out.println("Nó pai: " + ((PatNodeInt) parentNode).index + " " + msg + " Int: " + aux.index);
                } else {
                    System.out.println("Nó pai: " + parentNode + " " + msg + " Int: " + aux.index);
                }
                central(next, aux.right, "right");
            } else {
                PatEndNode aux = (PatEndNode) next;
                if (parentNode != null) {
                    System.out.println("Nó pai: " + ((PatNodeInt) parentNode).index + " " + msg + " Ext: " + aux.item);
                } else {
                    System.out.println("Nó pai: " + parentNode + " " + msg + " Ext: " + aux.item);
                }
            }
        }
    }

    public void print() {
        this.central(null, this.root, "root");
    }

    

    public boolean search(int searchItem) {
        return search(searchItem, this.root);
    }


    
}
