package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class _2Insert {
/*
    public static node insert(node root, int x) {// Recursive   Time O(h) , Auxiliary space O(h) for recursive calls'
        node temp = new node(x);
        if (root == null) {
            return temp;
        }
        if (x > root.key) {
            root.right = insert(root.right, x);// because we have to connect(insert) new BinarySearchTree2.node (temp)
        }
        if (x < root.key) {
            root.left = insert(root.left, x);
        }
        return root;
    }
*/
    public static node insert(node root, int x) {//Iterative   Time O(h), Auxiliary space O(1)
        node temp = new node(x);
        if (root == null) {
            return temp;
        }
        node curr = root, parent = null;
        while (curr != null) {
            parent = curr;
            if (x == curr.key) {
                return root;
            }
            if (x > curr.key) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (x > parent.key) {
            parent.right = temp;
        } else {
            parent.left = temp;
        }
        return root;
    }

    public static void printLevel(node root) {
        if (root == null) {
            return;
        }
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                node curr = q.poll();
                System.out.print(curr.key + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        node root = new node(20);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
//        printLevel(root);
        root = insert(root, 25);
        printLevel(root);
    }
}
/*

         20
       /    \
     10      30
    /  \
   5    15

 */
