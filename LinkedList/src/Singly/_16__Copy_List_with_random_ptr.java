package Singly;

class Node {
    int data;
    Node next;
    Node random;
    public Node(int data) {
        this.data = data;
    }
}


public class _16__Copy_List_with_random_ptr {
//   // Broth force
//    public static ListNode cloneLinkedList(ListNode head) { // TC : O(n) , SC : O(n)
//        ListNode curr = head;
//        ListNode cloneCurr;
//        HashMap<ListNode, ListNode> map = new HashMap<>();
//        while(curr != null) {
//            map.put(curr, new ListNode(curr.data));
//            curr = curr.next;
//        }
//        curr = head;
//        while(curr != null) {
//            cloneCurr = map.get(curr);
//            cloneCurr.next = map.get(curr.next); // next ptr
//            cloneCurr.random = map.get(curr.random); // random ptr
//            curr = curr.next;
//        }
//        return map.get(head);
//    }

/**
     * Create the copy of node 1 and insert it between node 1 and node 2 in the original Linked List,
        create the copy of node 2 and insert it between 2nd and 3rd node and so on. Add the copy of N after the Nth node

     * Now copy the arbitrary(random) link in this fashion:
        original->next->random = original->random->next

     * Now restore the original and copy linked lists in this fashion in a single loop.
        original->next = original->next->next;
        copy->next = copy->next->next;

     * Make sure that the last element of original->next is NULL.
*/
// [GFG] https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
// [Leetcode] https://raw.githubusercontent.com/hot13399/leetcode-graphic-answer/master/138.%20Copy%20List%20with%20Random%20Pointer.jpg
    public static Node cloneLinkedList(Node head) { // TC : O(n)   [use pen & paper]
        Node curr = head;

        // loop 1: traverse the list , all the copy are insert in between two original nodes
        while(curr != null) {
            Node Next = curr.next;           // since next ptr of curr point to duplicate node, we save the 2nd node
            curr.next = new Node(curr.data); // now next ptr of curr point to duplicate node (which is the copy of curr node)
            curr.next.next = Next;               // next ptr of dup node point to original next node
            curr = Next;                         // now curr becomes Next, keep moving curr ptr until it becomes null
        }

        // loop 2: assign random pointers for the copy nodes
        curr = head;
        while(curr != null) {
            curr.next.random = curr.random.next;
            curr = curr.next.next;//here duplicate nodes are inserted between 2 original nodes,so we have to jump on next original node
        }                                                                           // that's why we move curr by 2 (steps)

        //loop 3: now we restore the original list, and extract copy list
        curr = head;
        Node dummy = curr.next; // here we iterate copy ptr,so we need to save(store) head ptr
        Node copy = dummy;           // here 2nd node is 1st duplicate node so that we initialize 2nd node as dummy
        while(copy != null && copy.next != null) {
            curr.next = curr.next.next;
            curr = curr.next;

            copy.next = copy.next.next;
            copy = copy.next;
        } // dummy is the head of the duplicate list
        return dummy; // if we return head instead of dummy, it references to original list
    }                      // return dummy, it references to new list not original list

    public static void printList(Node head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;
        printList(head);
        Node res = cloneLinkedList(head);
        res.next.data = 10;
        printList(res);
        printList(head);
    }
}
