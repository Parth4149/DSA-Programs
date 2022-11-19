package LinkList.Singly;

// segregate even odd nodes of linked-list
public class _13EvenOddNodes {
    public static ListNode segregateEvenOdd(ListNode head) {
        // here we use 2 dummy nodes because we store even nodes in evenList and odd nodes in oddList
        // after the traversal of linked list we may lose first(head) node of both even and odd list so that we need 2 dummy nodes
        ListNode dummy1 = new ListNode(0);
        ListNode evenList = dummy1;

        ListNode dummy2 = new ListNode(0);
        ListNode oddList = dummy2;
        while (head != null) {
            if (head.data % 2 == 0) { // even
                evenList.next = head;
                evenList = evenList.next;
            } else { // odd
                oddList.next = head;
                oddList = oddList.next;
            }
            head = head.next;
        }
        oddList.next = null; // the next ptr of last node point to null
        evenList.next = dummy2.next; // next ptr of evenList point to first odd node
        return dummy1.next; //
    }

    public static ListNode push(ListNode head, int x) {
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

    public static void PrintList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = push(head, 17);
        head = push(head, 15);
        head = push(head, 8);
        head = push(head, 12);
        head = push(head, 10);
        head = push(head, 5);
        head = push(head, 4);

        PrintList(head);
        head = segregateEvenOdd(head);
        PrintList(head);
    }
}