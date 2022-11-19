package Tree;

class node {
    int key;
    node left, right;

    public node(int x) {
        key = x;
    }
}

public class _1orders {
    public static void inorder(node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void preorder(node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) {
        node root = new node(20);
        root.left = new node(10);
        root.right = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(15);
//        inorder(root);
//        preorder(root);
        postorder(root);
    }
}
