package Tree;

public class _2HeightOfBinary {

    public static int HeightOfTree(node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(HeightOfTree(root.left), HeightOfTree(root.right));
        }
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

        System.out.println(HeightOfTree(root));
    }
}
