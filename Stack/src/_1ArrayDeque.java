import java.util.ArrayDeque;

/**
 * the ArrayDeque class will often times be faster than a Queue or a Stack.
 * This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.

 * ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends
 * and LinkedList implementation is efficient for removing the current element during the iteration.
 * The LinkedList implementation consumes more memory than the ArrayDeque.
 */
public class _1ArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> q=new ArrayDeque<>();// Stack
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println(q);

        q.addLast(70);
        q.addFirst(5);
        System.out.println(q);

        q.removeFirst();
        System.out.println(q);
    }
}
