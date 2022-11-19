package BinarySearchTree;

public class _5Ceil {
    public static node Ceil(node root, int x) {// time : O(h) , space O(1)
        node res = null;
        while (root != null) {//  left
            if (root.key == x) {
                return root;
            }
            if (x < root.key) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    /*

        20
      /    \
    10      30
   /  \    /
  5   15  25

*/
    public static void main(String[] args) {
        node root = new node(20);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
        root.right.left = new node(25);

//        BinarySearchTree2.node ans= t.Ceil(root,3);//5
        node ans = Ceil(root, 23);//25
//        BinarySearchTree2.node ans=t.Ceil(root,35);//null
        // greater or equal
        if (ans == null)
            System.out.println("null");
        else
            System.out.println(ans.key);
    }
}
