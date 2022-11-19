package LinkList.Singly;

// Delete a node with only pointer given to it
public class _11_DeleteWithGivenPointer {
    public static void deleteNode(ListNode ptr) {
        ptr.data = ptr.next.data;// update value of ptr
        ptr.next = ptr.next.next;// delete ptr
    }

    public static void PrintList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
//        head.next.next.next = new node(40);
//        head.next.next.next.next = new node(50);

//        PrintList(head);
        deleteNode(head.next);
        PrintList(head);
    }
}
