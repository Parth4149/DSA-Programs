import java.util.LinkedList;
import java.util.Queue;

class node {
    int key;
    node left,right;
    public node(int x) {
        key = x;
    }
}
class Test1 {
    /**

//  In Recursive implementation, it requires  Auxiliary space for function call stack

    public static boolean Search(node root,int x){// Recursive  Time complexity O(h) , Auxiliary space O(h)
        if(root==null){
            return false;
        }
        if(root.key==x){
            return true;
        }
        if(x>root.key){
            return Search(root.right,x);
        }
        else{
            return Search(root.left,x);
        }
    }


     * Iterative solution is better. it does not require extra Auxiliary space
     * It works in constant Auxiliary space
     * note : for self balanced BST Time complexity is O(log n)
     */
    // minimum worst case time : O(logn) and maximum worst case time : O(h)  // h : height of a tree
    public static boolean Search(node root,int x){// Iterative  Time complexity O(h) , Auxiliary space O(1)
        if(root==null){
            return false;
        }
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            node curr=q.poll();
            if(curr.key==x){
                return true;
            }
            if(root.left!=null){
                q.add(root.left);
            }
            if(root.right!=null){
                q.add(root.right);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        node root=new node(20);
        root.left=new node(10);
        root.right=new node(30);
        root.left.left=new node(5);
        root.left.right=new node(15);

        System.out.println(Search(root,30));
    }
}
/*

         20
       /    \
     10      30
    /  \
   5    15

 */
