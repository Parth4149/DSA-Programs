package LinkList.Singly;

public class _9detectCycle {
    /**
     * Traverse linked list using two pointers.
     * Move one pointer(slow) by one and another pointer(fast) by two.
     * if two pointer meet at the same node then there is a loop, if pointers do not me meet then there is no loop in list
     */
    public static boolean isCycle(ListNode head) {  //Floyd's algorithm // time theta(n) // OR O(m+n) where n is loop and m is linear list
        // initialize 2 pointers
        ListNode slow = head, fast = head;
        // if fast become null then fast.next throws null pointer exception so that we are using &&
        while (fast != null && fast.next != null) {
            slow = slow.next;                   // move flow ptr by 1
            fast = fast.next.next;              // move fast prt by 2
            if (slow == fast) { // meeting point
                return true;
            }
        }
        return false;
    }
// we generally use this in loop first iteration , next iteration ... last iteration
/**
    // we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not.
    // every node checks if the next is pointing to temp or not
    public static boolean isLoop(node head) {    // TC : O(n) ,  SC : O(1)
        node temp = new node(0);
        node curr = head;
        while (curr != null) {
            if (curr.next == null) {
                return false;
            }
            if (curr.next == temp) {      // we are using the next pointer of a node as a flag
                return true;
            }
            node currNext = curr.next;    // save next node so we do not lose next node
            curr.next = temp;           // all the nodes point to temp
            curr = currNext;        // now curr becomes Next
        }
        return false;
    }


    //  Hash Table
    public static boolean isLoop(node head) {    // time : O(n) ,  Aux space : O(n)
        HashSet<node> s = new HashSet<>();
        for (node curr = head; curr != null; curr = curr.next) {
            if (s.contains(curr)) {
                return true;
            }
            s.add(curr);
        }
        return false;
    }
 */

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);// meeting point
        head.next.next.next.next.next = head.next.next.next;
        System.out.println(isCycle(head));
    }
}
