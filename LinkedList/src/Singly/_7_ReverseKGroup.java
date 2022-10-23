package Singly;
// Reverse Nodes in k-Group
public class _7_ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode curr = head, prev = null, Next = null;
        int i = 0;

        // Count the no of nodes in group , check the no. of nodes in group = k  [Leetcode]
//        while(curr != null && i < k) {
//            curr = curr.next;
//            i++;
//        }
//        if(i < k){ // we don't reverse the list and simply return the head
//            return head;
//        }*

//        i = 0; curr = head;

        // reverse
        while(curr != null && i < k) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
            i++;
        }
        // now we have curr head, new head of curr group(after reverse a group of sublist) and head of next group
        if(Next != null && i == k){ // optional
            head.next = reverseKGroup(Next, k);// head point to res of next group
        }
        return prev; // prev will be new head of the group
    }

    public static void PrintList(ListNode head){
        if(head == null){
            return ;
        }
        System.out.print(head.data+" ");
        PrintList(head.next);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
//        head.next.next.next.next.next = new node(60);

        head = reverseKGroup(head,3);
        PrintList(head);
    }
}