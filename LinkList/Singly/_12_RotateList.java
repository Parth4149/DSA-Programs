package LinkList.Singly;

public class _12_RotateList {  // rotate list
    /**
     * NOTE:
     * if k>count, we should consider compute k modulo count (k%count) to find reminder
     * let us take one example
     * k=7 and count=5
     * in this case, ( generally  rotate the list by 7 places)
     * if we take 7%5 = 2 , rotate the list only by 2 instead of 7
     * both gives same results, so we consider second case
     */

    // left rotate , reverse first k nodes , make k+1 node head head
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // initialize 2 ptr as head
        ListNode slow = head, fast = head;
        int count = 0;
        // Start with the first node and count the no of nodes present after that node.
        while (slow != null) {
            slow = slow.next;
            count++;
        }
        k = k % count;
        if (k == 0) {// if k==count, k%count=0 in this case, no need to rotate list and simply return head
            return head;
        }

        //First,reach the K-th node from the starting node of the given linked list. Save the K-th node's address in a ptr variable.
        while (fast != null && k-- > 0) {  // difference between two pointer should be 2
            fast = fast.next;
        }
        slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;               // here
            fast = fast.next;
        }
        fast.next = head;// make circular linked list
        head = slow.next;// update head,  we assign next node of slow as head
        slow.next = null;// change next of slow to null
        return head;
    }

    public static ListNode rotateLeft(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        k = k % count; // if k > count, we take k % count and move only k nodes
        if (k == 0) return head;

        curr = head; // update the curr
        while (curr.next != null) { // travers the list
            curr = curr.next;
        }
        curr.next = head; // make circular linked list
        //now curr reach the K-th node from the last node Save the K-th node's address in a ptr variable.
        while (k > 0) {     // move k iteration
            curr = curr.next;
            k--;
        }
        head = curr.next; // update the head , we assign next node of curr as head
        curr.next = null;  // make singly linked list
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
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        PrintList(head);
//        head = rotateRight(head,2);
//        head = rotateLeft(head,2);
        head = rotateRight2(head, 2);
        PrintList(head);

    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        // here we are maintaining k distance between 2 pointers
        // move k iteration
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head; // make circular ll
        head = slow.next; // now head becomes next ptr of slow
        slow.next = null; // make singly ll
        return head;
    }
}
