package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _6MaximumInBinaryTree {

    //    public static int findMax(Tree2.node root){// Recursive
//        if(root==null){
//            return Integer.MIN_VALUE;
//        }
//
//        else{
//            return Math.max( root.key,Math.max( findMax(root.left),findMax(root.right) ) );
//        }
//    }

    public static int findMax(node root) {// Iterative Time complexity : O(w), where w = width of tree
        if (root == null) {
            return 0;
        }
        Queue<node> q = new LinkedList<>();
        q.add(root);
        int res = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            node curr = q.poll();
            res = Math.max(res, curr.key);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return res;
    }

    /*
             20
           /    \
         10      30
        /  \
       5    15

    */
    public static void main(String[] args) {
        node root = new node(20);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        System.out.println(findMax(root));
    }
}
