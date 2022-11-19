package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class _3_deletion {
    public static node delNode(node root, int x) {// time O(h) , space O(h)
        if (root == null) {
            return null;
        }
        if (x > root.key) {
            root.right = delNode(root.right, x);
        } else if (x < root.key) {
            root.left = delNode(root.left, x);
        } else {// 3 cases
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            } else {
                node succ = getSucc(root);
                root.key = succ.key;
                root.right = delNode(root.right, succ.key);
            }
        }
        return root;
    }

    public static node getSucc(node root) {// it returns closest greater // leaf left BinarySearchTree2.node or inorder left
        node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    /*
         20
       /    \
     10      30
    /  \    /
   5   15  25
 */
    public static void main(String[] args) {// 3 cases
        node root = new node(20);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.right.left = new node(25);
        root = delNode(root, 5);
        printLevel(root);
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
}
