package Singly;

class _5FindMiddle {
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head; // OR we can use fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
//        head.next.next.next.next.next = new node(60);

        ListNode mid = findMiddle(head);
        System.out.println(mid.data);
    }

}
