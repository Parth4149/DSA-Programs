package Singly;

public class _3Search {
//    public static int Search(node head,int x){// iterative  TC : O(n)  n : number of nodes
//        node curr = head;
//        for(int i = 1; curr != null; i++){
//            if(curr.data == x){
//                return i;
//            }
//            curr = curr.next;
//        }
//        return -1;
//    }

    public static int Search(ListNode head, int x) { // recursive
        if (head == null) {
            return -1;
        }
        if (head.data == x) {
            return 1;
        } else {
            // 1st node's res depends on 2nd node's res , 2ns node's res depends on 3rd node's res and so on..
            int res = Search(head.next, x);       // here comp of res starting from last fun call
            if (res == -1)                       // rest of the stmt (if-else) are executed after removing fun call from stack
                return res; // return -1;
            else
                return 1 + res;

        }
        // here last node(40) say hey Search(null, x) give me the res so I can return this res to my parent
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(70);
        int res = Search(head, 50);
        System.out.println(res);
    }
}
