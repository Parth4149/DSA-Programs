package Doubly;
// insert and delete at beginning,End is possible in O(1) time by maintaining head & tail

public class _1Insertion {
    public node insertAtBeginning(node head,int x){
        node temp=new node(x);
        if(head==null)
            return temp;
        temp.next=head;
        head.prev=temp;
        return temp;
    }
    public node insertAtEnd(node head,int x){
        node temp=new node(x);
        if(head==null)
            return temp;
        node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        return head;
    }
    public node insertAtPosition(node head,int pos,int x){
        node temp=new node(x);
        if(pos==1){
            temp.next=head;
            head.prev=temp;
            return temp;
        }
        node curr=head;
        for(int i=1; i<=pos-2 && curr!=null; i++){
            curr=curr.next;
        }
        if(curr==null || pos<=0){
            return head;
        }
        temp.next=curr.next;
        curr.next.prev=temp;
        curr.next=temp;
        temp.prev=curr;
        return head;
    }
    public void printList(node head){
        if(head==null)
            return;
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _1Insertion t=new _1Insertion();

        node head=new node(5);
        head=t.insertAtEnd(head,10);
        head=t.insertAtEnd(head,20);
        head=t.insertAtEnd(head,30);
        head=t.insertAtEnd(head,40);
        t.printList(head);
//        head=t.insertAtBeginning(head,100);
        head=t.insertAtPosition(head,3,33);
        t.printList(head);
    }
}
