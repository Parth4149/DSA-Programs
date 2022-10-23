class Test8 {
//Children Sum Property
    public boolean isCSum(node root){// time : O(n) , space : O(h)
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        int sum=0;
        if(root.left!=null)
            sum+=root.left.key;
        if(root.right!=null)
            sum+=root.right.key;

        return (root.key==sum && isCSum(root.left) && isCSum(root.right));
    }
/**
          20
        /    \
      8      12
    /  \
   5    3
**/
    public static void main(String[] args) {
        Test8 t=new Test8();
        node root=new node(20);
        root.left=new node(8);
        root.right=new node(12);
        root.left.left=new node(3);
        root.left.right=new node(5);
        System.out.println(t.isCSum(root));
    }
}
