package Singly;

public class _10_DetectRemoveCycle {


/**
 * |------m------|---k---|
 * 🟠->🟡->🟢->🟤->🟣->🟡->🟢->🟡                🟠->🟡->🟢->🟤->🟣->🟡->🟢->🟡->X
 * | ️             |
 * \ ️n ➰  loop  /
 * \_____________/
 * <p>
 * where m is distance btn slow head and starting point of the cycle
 * n is distance btn starting point of the loop and first meeting point
 * x is a no of iterations mady by slow before the first meeting point
 * Y        !!                     fast
 * <p>
 * (Distance travelled by slow) * 2 = (Distance travelled by fast)
 * (m + k + x*n) * 2 = m + k + y*n
 * (m+k) = n(y - 2x)
 * (m+k) is a multiple of n
 */

// find the length of the loop(cycle)
// find the first node of the loop(cycle)

    public static void RemoveDetectCycle(ListNode head) {   // time : O(n + m) where n is loop and m is linear list
        if(head == null) {
            return;
        }
        // initialize 2 pointers as head (initial node)
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null) { // cycle detection
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){// first meeting point
                slow = head; // slow ptr as head
                // now slow start iterating from head and fast iterating from meeting point
                while(fast.next != slow.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    public static boolean isLoop(ListNode head){   // Floyd's algorithm  // time O(n) // OR O(m+n) where n is loop and m is linear list
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){   // meeting point
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = head.next.next;

        // length of the cycle(loop)
        cycleLength(head); // 3

        System.out.println(isLoop(head)); // true
        RemoveDetectCycle(head);
        System.out.println(isLoop(head)); // false
    }
    // Find the length of the loop
    public static int cycleLength(ListNode head) {   // time : O(n + m) where n is loop and m is linear list
        if(head == null) {
            return 0;
        }
        // initialize 2 pointers as head (initial node)
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null) { // cycle detection
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){// first meeting point
                slow = head; // slow ptr as head
                // now slow start iterating from head and fast iterating from meeting point
                while(fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                int count = 0;
                do {
                    fast = fast.next;
                    count++;
                }while(slow != fast);
                System.out.println(count);
                return count;
            }
        }
        return 0;
    }
}