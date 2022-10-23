package Singly;

import java.util.HashSet;
//removeDuplicate from a sorted singly linked list
public class _8RemoveDuplicate {
    /**
     * head says hey fun give me result of rest of the list, call fun again and so on [recursion is going downward]
     * when the base condition hits, there is only last element(node) left [now recursion is going upward(last call rm from stack)]
     */

    // recursion approach
//    public static node removeDuplicate(node head){ // TC : O(n) , takes some space for recursion call
//         if(head == null || head.next == null){
//             return head;
//         }
//         head.next = removeDuplicate(head.next);   //
//         return (head.data == head.next.data) ? head.next : head;
//    }

    public static ListNode removeDuplicate(ListNode head) { // TC : O(n)
        if(head == null) {
            return null;
        }
        ListNode curr = head;
        while(curr.next != null) {
            if(curr.data == curr.next.data){
                curr.next = curr.next.next; // curr pointer point to next of next node
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }

    // remove duplicate from unsorted list
    public static ListNode removeDuplicateUnsorted(ListNode head) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            set.add(curr.data);
            if(set.contains(curr.next.data)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
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
        return head;
    }
    public static void printList(ListNode head){
        if(head == null){
            return;
        }
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(30);
        head.next.next.next.next = new ListNode(30);
        head = removeDuplicate(head);
        printList(head);

        ListNode head2 = null;
        head2 = push(head2,5);
        head2 = push(head2,2);
        head2 = push(head2,2);
        head2 = push(head2,3);
        head2 = push(head2,3);
//        printList(head2);
//        head2 = removeDuplicateUnsorted(head2);
//        printList(head2);
    }
}
