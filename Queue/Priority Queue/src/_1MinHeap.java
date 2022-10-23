import java.util.PriorityQueue;

class _1MinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        pq.add(10);// Minimum is top (in MinHeap) //  it gives priority to minimum order
        pq.add(20);
        pq.add(15);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
