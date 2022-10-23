import java.util.LinkedList;
import java.util.Queue;
class Test7 {
    /**
    int maxLevel=0;
    public void LeftView(node root,int level){//Recursive
        if(root==null){
            return ;
        }
        if(maxLevel<level){
            System.out.print(root.key+" ");
            maxLevel=level;
        }
        LeftView(root.left,level+1);
        LeftView(root.right,level+1);
    }
    public void printLeftView(node root){
        LeftView(root,1);
    }
    **/

    //Iterative approach
    public void LeftView(node root){// time : O(n) , space : O(n) (in worst case) // space : theta(w) best case
        if(root==null){
            return;
        }
        Queue<node> q=new LinkedList<>();// level order traversal
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0; i<count; i++){
                node curr=q.poll();
                if(i==0){
                    System.out.print(curr.key+" ");// prints the first node
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }

        }
    }

    /**
         20
       /    \
     10      30
            /  \
          25    35

**/
    public static void main(String[] args) {
        Test7 t=new Test7();
        node root=new node(20);
        root.left=new node(10);
        root.right=new node(30);
        root.right.left=new node(25);
        root.right.right=new node(35);
//        root.right.right=new node(40);
//        root.right.left=new node(25);
//        root.right.left.right=new node(27);

        t.LeftView(root);
    }
}
