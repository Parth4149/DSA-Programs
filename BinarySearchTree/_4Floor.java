package BinarySearchTree;

public class _4Floor {
    public static node Floor(node root, int x) {//Iterative  Time O(h), Auxiliary space O(1)
        node parent = null;
        while (root != null) {  // right
            if (x == root.key) {
                return root;
            }
            if (x < root.key) {
                root = root.left;
            } else {
                parent = root;
                root = root.right;
            }
        }
        return parent;
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

        node ans = Floor(root, 13);//10
//        BinarySearchTree2.node ans=Floor(root,27);//25
//        BinarySearchTree2.node ans=Floor(root,3);//null
        //lower or equal
        if (ans == null)
            System.out.println("null");
        else
            System.out.println(ans.key);
    }

}
