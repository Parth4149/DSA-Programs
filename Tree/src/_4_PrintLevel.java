import java.util.Queue;
import java.util.LinkedList;

class Test4 {
    // level order traversal
    public static void PrintLevel(node root){// time : theta θ(n)   , auxiliary space : O(n)
        if(root==null){
            return ;
        }
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            node curr=q.poll();
            System.out.print(curr.key+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }

    // level order traversal line by line
    public static void PrintLevelLine(node root){// time : O(n) ,  auxiliary space : O(n)
        if(root==null){
            return ;
        }
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();// important
            for(int i=0; i<count; i++){
                node curr=q.poll();
                System.out.print(curr.key+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }

/*
      O         auxiliary space : theta θ(1)
    /
   O
  /
 O

       O         auxiliary space : theta θ(n)
     /   \
    O     O
   / \   / \
  O   O O   O



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

//        PrintLevel(root);
        PrintLevelLine(root);
    }
}
