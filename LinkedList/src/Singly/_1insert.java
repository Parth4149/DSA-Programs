package Singly;

public class _1insert {
    public static ListNode InsertAtBegin(ListNode head, int x) {
        ListNode temp = new ListNode(x);
        temp.next = head;
        return temp;
    }

    public static ListNode InsertAtEnd(ListNode head, int x) {
        ListNode temp = new ListNode(x);
        if (head == null) {
            return temp;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static ListNode Insert(ListNode head, int pos, int x) {
        ListNode temp = new ListNode(x);
        if (head == null || pos == 1) {
            temp.next = head;
            return temp;
        }
        ListNode curr = head;
        for (int i = 0; i < pos - 2 && curr.next != null; i++) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static void PrintList(ListNode head) { // iterative
        if (head == null)
            return;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void rPrint(ListNode head) {   // Recursive
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        rPrint(head.next);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

//        head = InsertAtBegin(head,5);
//        PrintList(head);
//        head = InsertAtEnd(head,55);
//        System.out.println();
//        PrintList(head);

        head = Insert(head, 2, 15);
        PrintList(head);
//        head = Insert(head,7,30);
//        PrintList(head);
    }
}