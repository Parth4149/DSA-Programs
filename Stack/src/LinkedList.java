class node{
    int data;
    node next;
    node(int data){
        this.data=data;
    }
}
class StackLL {
    public void push(node head,int x){
        node temp=new node(x);
        node curr=head;
        if(curr==null){
            head.next=temp;
        }
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=temp;
    }
    public int pop(node head){
        node curr=head;
        if(curr==null){
            return -1;
        }
        while(curr.next.next!=null){
            curr=curr.next;
        }
        int temp= curr.next.data;
        curr.next=null;
        return temp;
    }
    public int peek(node head){
        node curr=head;
        if(curr==null){
            return -1;
        }
        while(curr.next!=null){
            curr=curr.next;
        }
        return curr.data;
    }
    public static void printList(node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        StackLL s=new StackLL();

        node head=new node(10);
        head.next=new node(20);
        s.push(head,30);
        s.push(head,40);
        s.pop(head);
        System.out.println(s.peek(head));
        printList(head);
    }
}
