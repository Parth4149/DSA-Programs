import java.util.Comparator;
import java.util.PriorityQueue;

class _1MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
        pq.add(10);
        pq.add(20);// maximum is top (in MaxHeap)// it gives priority to maximum order
        pq.add(15);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
