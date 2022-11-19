package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _5SizeofTree {

//   //    public static int size(Tree2.node root){// Recursive Time complexity : O(n) , auxiliary space : O(h)
//        if(root==null){
//            return 0;
//        }
//        else{
//            return 1 + size(root.left) + size(root.right);
//        }
//    }

    public static int size(node root) {// Iterative Time complexity : O(w), where w = width of tree
        if (root == null) {
            return 0;
        }
        Queue<node> q = new LinkedList<node>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        node root = new node(20);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);

        System.out.println(size(root));
    }
}
