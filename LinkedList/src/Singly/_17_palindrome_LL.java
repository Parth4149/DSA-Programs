package Singly;

public class _17_palindrome_LL {

//    public static boolean isPalindrome(node head) { // TC : theta(n) , SC : theta(n)
//        Deque<node> stack = new ArrayDeque<>();
//        // traverse the list
//        for(node curr = head; curr != null; curr = curr.next) {
//            stack.push(curr);
//        }
//        //
//        for(node curr = head; curr != null; curr = curr.next) {
//            if(stack.pop().data != curr.data) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public static boolean isPalindrome(node head) { // TC : theta(n^2)
//        node slow = head, fast = head;
//        int count = 0;
//        while(slow != null) {
//            count++;
//            slow = slow.next;
//        }
//        slow = head;
//        count = count - 1; // decrement by 1
//
//        while(count > 0) {
//            int k = count;
//            while(k-->0) {
//                fast = fast.next;
//            }
//            if(slow.data != fast.data) {
//                return false;
//            }
//            slow = slow.next;
//            fast = slow;
//            count = count - 2; // decrement by 2
//        }
//        return true;
//    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        // find out right middle node
        while(fast.next != null && fast.next.next != null) { // keep doing until fast ptr react at last or 2nd last node
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = head;
        // call reverse function
        ListNode rev = reverse(slow.next); // reverse 2nd half

        while(rev != null) {
            if(curr.data != rev.data) {
                return false;
            }
            curr = curr.next;
            rev = rev.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode LastNode = reverse(head.next);
        head.next.next = head; // reverse connection, next ptr of 2nd node point to 1st node (itself)
        head.next = null; // i need to make next ptr of 1st node null
        return LastNode;
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
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        boolean ans = isPalindrome(head);
        System.out.println(ans);
//        printList(head);
    }
}
