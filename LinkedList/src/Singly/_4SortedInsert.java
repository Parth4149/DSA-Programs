package Singly;

public class _4SortedInsert {
    public static ListNode insertNode(ListNode head, int x) {
        ListNode temp = new ListNode(x);
        ListNode curr = head;
        if (head == null || x < head.data) {
            temp.next = head;
            return temp;
        }
        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static void Print(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        Print(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head = insertNode(head, 455);
        Print(head);
    }
}
