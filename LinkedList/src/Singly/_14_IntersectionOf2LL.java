package Singly;

import java.util.HashSet;

public class _14_IntersectionOf2LL {
/** // [NOTE] Read Comments
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) { // TC : O(m + n) , SC : O(m)
        // create an empty hashset
        HashSet<ListNode> set = new HashSet<>();
        // traverse the first list and put all of its nodes into set
        while(head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        // traverse the 2nd list and look for every node in set
        // As soon as we find a node present in set, we return it
        while(head2 != null) {
            if(set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
*/
    // Efficient approach
    // assume the dist btn head of smaller list & intersection node is m and dist btn head of bigger & intersection node is (d+m).
    // here the bigger list has d more nodes
    // if smaller list reaches at null then it will start from head of the bigger list
    // when bigger list reaches at null then smaller should be traverse d nodes and bigger start from head of smaller
    // now both list have same distance btn curr node and tail node
    // in 2nd traversal it should be reaches at common node or null
    /**
     * if listA and listB have the same length, this solution will terminate in no more than 1 traversal
     * if both list have diff length,                     "         "           "            2 traversal
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        if(headA == null || headB == null) return null;

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        // now we traverse both list simultaneously until we get a common node
        // if curr1 becomes null, curr1 start traversing from headB , similarly curr2 -> headA
        while(curr1 != curr2) {
            curr1 = (curr1 == null) ? headB : curr1.next;
            curr2 = (curr2 == null) ? headA : curr2.next;
        }
        return curr1;
    }

    // Another approach
    public static ListNode getIntersectionNode2(ListNode head1, ListNode head2) { // TC : O(m + n)
        ListNode curr1 = head1, curr2 = head2;
        // count nodes in both list
        int count1 = 0, count2 = 0;
        while(curr1 != null) {
            curr1 = curr1.next;
            count1++;
        }
        while(curr2 != null) {
            curr2 = curr2.next;
            count2++;
        }
        curr1 = head1;
        curr2 = head2;

        int d = Math.abs(count1 - count2);
        // traverse the bigger list d times in order to make distance between starting node and intersection node equal
                                                                    // so that we can easily find intersection(common) node
        if(count1 > count2) {
            while(curr1 != null && d-->0) {
                curr1 = curr1.next;
            }
        } else {
            while(curr2 != null && d-->0) {
                curr2 = curr2.next;
            }
        }

        // now we traverse both list simultaneously until we get a common node
        while(curr1 != curr2) {
            curr1 = curr1.next; // both list move by 1
            curr2 = curr2.next;
        }
        return curr1; // curr2
    }
    public static ListNode push(ListNode head, int x) {
        ListNode temp = new ListNode(x);
        if(head == null){
            return temp;
        }
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = temp;
//        temp.next = null;
        return head;
    }
    public static void printList(ListNode head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
/**             |-----m----|
                5 -> 15 -> 35 -> 50 -> null
                          /
    8 -> 10 -> 12 -> 21 ↗
   |--d---|-----m-----|   where m is the distance between 1st node of smaller list and intersection node
*/
    public static void main(String[] args) {
        ListNode head1 = null;
        head1 = push(head1,5);
        head1 = push(head1,15);
        head1 = push(head1,35);
        head1 = push(head1,50);

        ListNode head2 = null;
        head2 = push(head2,8);
        head2 = push(head2,10);
        head2 = push(head2,12);
        head2 = push(head2,21);
        head2.next.next.next.next = head1.next.next;

        printList(head1); // smaller list
        printList(head2); // bigger list

//        node res = getIntersectionNode(head1, head2);
        ListNode res = getIntersectionNode(head1, head2);
        System.out.println(res.data); // 35
    }

    /**
     * Case 1 (have Intersection & Equal Len)
     * Case 2 (not have Intersection & Equal Len)
     * Case 3 (Have Intersection & Different Len)
     * Case 4 (not have Intersection & Different Len)


     Case 3 (Have Intersection & Different Len):
     *             a
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *        b
     *                  a
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *             b

     * A:          a1 → a2
     *                    ↘ a
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3

     *                  b
     * A:          a1 → a2
     *                    ↘      a
     *                      c1 → c2 → c3 → null
     *                    ↗ b
     * B:     b1 → b2 → b3

     * A:          a1 → a2
     *                    ↘           a
     *                      c1 → c2 → c3 → null
     *                    ↗      b
     * B:     b1 → b2 → b3

     * A:          a1 → a2
     *                    ↘                a = null, then a = b1
     *                      c1 → c2 → c3 → null
     *                    ↗           b
     * B:     b1 → b2 → b3

     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗                b = null, then b = a1
     * B:     b1 → b2 → b3
     *        a
     *             b
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *             a
     *                  b
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3 → null
     *                    ↗
     * B:     b1 → b2 → b3
     *                  a
     * A:          a1 → a2
     *                    ↘ b
     *                      c1 → c2 → c3 → null
     *                    ↗ a
     * B:     b1 → b2 → b3
     * Since a == b is true, end loop while(a != b), return the intersection node a = c1.
     */
}
