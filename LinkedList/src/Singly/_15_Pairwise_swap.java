package Singly;
//  Pairwise swap nodes of linked list

public class _15_Pairwise_swap {
//    // Broth force
//    public static node pairwiseSwap(node head) { // this approach is inefficient when we use objects as data
//        node curr = head;
//        while(curr != null && curr.next != null) {
//            int temp = curr.data; // swap
//            curr.data = curr.next.data;
//            curr.next.data = temp;
//            curr = curr.next.next; // move curr ptr by 2 (steps)
//        }
//        return head;
//    }


    // Iterative approach
    public static ListNode pairwiseSwap1(ListNode head) { // TC : O(n)
        if(head == null || head.next == null) {
            return head;
        }
        // we compute operation for 1st pair
        ListNode curr = head.next.next; // save 3rd node in curr node
        ListNode prev = head;           // here prev is old head
        head = head.next; // update head to next node,so 2nd node becomes new head
        head.next = prev;

        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;                // now prev becomes curr
            ListNode Next = curr.next.next; // save next ptr(node) of curr next node in Next, so we do not lose next ptr
            curr.next.next = curr;      // next ptr of curr next node point to curr (itself)
            curr = Next;                // now curr becomes Next
                                        // we keep moving the pointers and pairs
        }
        prev.next = curr; // we need to handle odd no. of nodes, in this case 1 last node left to swap
        return head;
    }


    // Recursive approach
    // here next ptr of 1st pair depend on the result of 2nd pair
    // when the base condition hits, there are 2 possibilities, 1 node left or 2 nodes(1 pair) left
    // if 1 node left, return last node
    // if 2 nodes left, swap the connection(link) and return its result

    public static ListNode pairwiseSwap(ListNode head) { // TC : O(n)
        // here there are 2 possibilities, the total no. of nodes is odd then we simply return head, and it is even we have to swap
        if(head.next == null) {                                                             // last two node and return the result
            return head;
        }
        else if(head.next.next == null) {
            ListNode Next = head.next; // save 2nd node
            Next.next = head; // reverse the link
            head.next = null; // this is necessary
            return Next;
        }
        // (variable) saves the result of next pair and call function (pass 3nd node as an argument)
        ListNode nextPair = pairwiseSwap(head.next.next);
        ListNode Next = head.next;  // save the 2nd node
        Next.next = head;       // now the next ptr of 2nd node point to 1st node (here we reverse the connection)
        head.next = nextPair;   // and next ptr of 1st node point to next pair (result of remaining pair)
        return Next;            // return Next node (2nd node becomes 1st node)
    }

    public static void printList(ListNode head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = pairwiseSwap(head);
        printList(head);
    }
}
