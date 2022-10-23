//Print Nodes at K distance
class Test3 {

    public static void printNodeAtK(node root,int k){
        if(root==null){
            return ;
        }
        if(k==0){
            System.out.print(root.key+" ");
        }
        else{
            printNodeAtK(root.left,k-1);
            printNodeAtK(root.right,k-1);
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
        node root=new node(20);
        root.left=new node(10);
        root.right=new node(30);
        root.left.left=new node(5);
        root.left.right=new node(15);

        printNodeAtK(root,1);
    }
}
