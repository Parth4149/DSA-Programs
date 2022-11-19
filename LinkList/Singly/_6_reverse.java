package LinkList.Singly;

public class _6_reverse {

    public static ListNode reverse1(ListNode head) {      // Iterative     time : O(n)
        if (head == null || head.next == null) {
            return head;
        }
        // initialize pointers
        ListNode curr = head, prev = null;
        // loop will run continue until curr pointer (won't) become null
        while (curr != null) {
            ListNode temp = curr.next;      // save(store) next node
            curr.next = prev;           // change the connection (reverse) next of curr point to prev
            // move 2 pointers
            prev = curr;                // now prev becomes head
            curr = temp;                // and curr becomes temp
        }
        return prev; // new head at the end
    }

    /**
     * in recursion, we have to maintain the last node becoz last node becomes new head.
     * rest_head says hey reverse fun give me the last node from rest of list, and it calls reverse [recursion is going downward]
     * when the base condition hits, there is only 1 node left (last node) [end of downward recursion]
     * and it returns last node now rest_head become last node [when it returns ln, the last fun call remove from rc stack and ctrl]
     * rest_tail becomes next of curr node and rest_tail point to curr node
     * and curr node point to null
     * and return rest_head
     */
    public static ListNode reverse2(ListNode head) {      // Recursive (part 1)   time : O(n)
        if (head == null || head.next == null) { // when the base condition hits, recursion will be going to upward
            return head;                                                            // start fun call rm frm stack
        }
        ListNode rest_head = reverse(head.next); // maintains the head pointer
        // rest of stmt will execute when recursion will be going to upward []
        head.next.next = head;          // now next node of curr_head point to curr_head (itself)
        head.next = null;               // and curr_head point to null becoz it is difficult to find end point of the list
        return rest_head;               // [Explain] 1st node -> curr head , 2nd node -> next node
    }
    // at the end head becomes new tail so curr head point to null
    //   OR  head.next.next = head;


//    public static node reverse(node head,node prev) {    // Recursive (part 2)   time :  O(n)
//        if(head == null) {
//            return prev;
//        }
//        else{
//            node temp = head.next;     // store the address of next node
//            head.next = prev;     // change the connection
//            return reverse(temp, head);     // prev node becomes head and head = temp , temp holds the address of next node
//        }
//    }

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
//        head.next.next.next.next = new node(50);

        head = reverse(head);
//        head=reverse(head,null);
        PrintList(head);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode new_head = reverse(head.next);
        head.next.next = head;
        head.next = head;
        head.next = null;
        return new_head;
    }
}
