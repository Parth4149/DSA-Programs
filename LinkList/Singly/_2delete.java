package LinkList.Singly;

// insert at the beginning,End and delete at the beginning is possible in O(1) time by maintaining head & tail
class _2delete {

    public static ListNode DeleteAtBegin(ListNode head) {
//        node curr = head;
//        if(curr == null ||  curr.next == null){
//            return null;
//        }
//        curr = curr.next;
//        return curr;
        return (head != null) ? head.next : null;
    }

    public static ListNode DeleteAtEnd(ListNode head) {
        ListNode curr = head;
        if (curr == null || curr.next == null) {
            return null;
        }
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static ListNode DeleteAtPosition(ListNode head, int pos) {
        if (pos == 1) {
            return (head != null) ? head.next : null;
        }
        ListNode curr = head;
        for (int i = 0; (i < pos - 2) && (curr.next != null); i++) {
            curr = curr.next;
        }
        if (curr.next == null || pos <= 0) {
            return head;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static void rPrint(ListNode head) {// Recursion
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        rPrint(head.next);
    }

    public static void PrintList(ListNode head) {
        if (head == null)
            return;
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
        head.next.next.next = new ListNode(40);
//        head = DeleteAtBegin(head);
//        head = DeleteAtEnd(head);
        head = DeleteAtPosition(head, 0);// IMP // for all cases ( if pos = any integer number)
        PrintList(head);
    }
}