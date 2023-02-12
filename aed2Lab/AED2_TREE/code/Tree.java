/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarytree1;

/**
 *
 * @author Juliana e Joao Pedro
 */
public class Tree {

    Node root;

    public void add(int newitem) {
        addRecursive(root, newitem);
    }

    public void addRecursive(Node currentnode, int newitem) {//no atual, item a ser inserido
        if (root == null) {//retorna um no criado com o item a ser inserido
            root = new Node(newitem);
        } else if (newitem < currentnode.item) {//se o valor for menor que o do no atual vamos pra esquerda
            if (currentnode.leftbranch != null) {
                addRecursive(currentnode.leftbranch, newitem);
            } else {
                currentnode.leftbranch = new Node(newitem);
            }

        } else if (newitem > currentnode.item) {//se o valor for maior que o do no atual vamos pra direita
            if (currentnode.rightbranch != null) {
                addRecursive(currentnode.rightbranch, newitem);
            } else {
                currentnode.rightbranch = new Node(newitem);
            }
        }           //se o valor for igual ao do no atual retornamos o no atual

    }

    public boolean search(int searchitem) {
        return searchRecursive(root, searchitem);
    }

    public boolean searchRecursive(Node currentnode, int searchitem) {
        if (currentnode == null) {
            return false;
        }
        if (searchitem < currentnode.item) {
            return searchRecursive(currentnode.leftbranch, searchitem);
        } else if (searchitem > currentnode.item) {
            return searchRecursive(currentnode.rightbranch, searchitem);
        } else if (searchitem == currentnode.item) {
            return true;
        }
        return false;
    }

    public int findFilhotao(Node root) {
        if (root.rightbranch == null) {
            return root.item;
        } else {
            return findFilhotao(root.rightbranch);
        }
    }

    public void delete(int deleteitem) {
        root = deleteRecursive(root, deleteitem);
    }

    public Node deleteRecursive(Node currentnode, int deleteitem) {
        if (currentnode == null) {
            return null;
        }
        if (deleteitem < currentnode.item) {
            deleteRecursive(currentnode.leftbranch, deleteitem);
        } else if (deleteitem > currentnode.item) {
            deleteRecursive(currentnode.rightbranch, deleteitem);
        }
        if (deleteitem == currentnode.item) {
            if ((currentnode.leftbranch == null) && (currentnode.rightbranch == null)) {
                return null;
            }
            if (currentnode.leftbranch == null) {
                return currentnode.rightbranch;
            }
            if (currentnode.rightbranch == null) {
                return currentnode.leftbranch;
            }
            int highest = findFilhotao(currentnode.leftbranch);
            currentnode.item = highest;
            currentnode.leftbranch = deleteRecursive(currentnode.leftbranch, highest);
            return currentnode;
        }
        return currentnode;
    }

    public void printree() {
        printPretty(root, 0, 0);
    }

    public void traverseInOrder(Node node, int lvl) {
        if (node != null) {
            traverseInOrder(node.leftbranch, lvl - 1);
            System.out.print(lvl + ": " + node.item + ". ");
            traverseInOrder(node.rightbranch, lvl + 1);
        }
    }

    public void printPretty(Node node, int left, int right) {
        if (node != null) {
            System.out.println("("+"L: "+node.leftbranch+" R: "+node.rightbranch+" item: "+node.item+")");
            printPretty(node.leftbranch, left+1,right);
            printPretty(node.rightbranch, left, right+1);
        }

    }

}
