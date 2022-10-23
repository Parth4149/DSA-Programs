import java.util.Arrays;
public class _1MinHeap {
    private int[] Heap;
    private int size;
    private int MaxSize;

    public static void main(String[] arg) {
        _1MinHeap minHeap = new _1MinHeap(7);
//        minHeap.Singly.insert(30);
//        minHeap.Singly.insert(7);
//        minHeap.Singly.insert(13);
//        minHeap.Singly.insert(21);
//        minHeap.Singly.insert(16);
//        minHeap.Singly.insert(12);
//        minHeap.Singly.insert(9);
        minHeap.Heap= new int[]{30, 7, 13, 21, 16, 12, 9};
        minHeap.size= minHeap.Heap.length;//size update

        System.out.println("Before build Heap : " + Arrays.toString(minHeap.Heap));
        minHeap.buildHeap();
        System.out.println("After build Heap : " + Arrays.toString(minHeap.Heap));

//        minHeap.print();
        System.out.println("\nThe Min Value is : " + minHeap.remove());
        System.out.println("\nThe Min Heap is :"+ Arrays.toString(minHeap.Heap)+"\n");
        minHeap.print();

//        minHeap.decreaseKey(4, 20); //it is used for update value in Heap
//        System.out.println("\nAfter update :"+ Arrays.toString(minHeap.Heap));// update 30 to 20
    }

    public _1MinHeap(int MaxSize) {// constructor
        this.MaxSize = MaxSize;
        this.size = 0;
        Heap = new int[MaxSize];
    }

    public void insert(int element) {
        if(size >= MaxSize) {
            return ;
        }
        Heap[size] = element;
        int current = size;
        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
    public int remove() {// removes and returns the minimum element from the heap
        // since it's a min heap, so root = minimum
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        minHeapify(0);
        return popped;
    }
    private void minHeapify(int pos) {    // Heapify the node at pos
        if (!isLeaf(pos)) {
            // check if root is larger than both child
            if (Heap[pos] > Heap[left(pos)] || Heap[pos] > Heap[right(pos)]) {
                // Swap with the left child and heapify
                if (Heap[left(pos)] < Heap[right(pos)]) {
                    swap(pos, left(pos));
                    minHeapify(left(pos));
                }
                // Swap with the right child and heapify
                else {
                    swap(pos, right(pos));
                    minHeapify(right(pos));
                }
            }
        }
    }
    public void buildHeap(){    // time complexity of build Heap is O(n) // n=size
        for(int i = (size/2) - 1; i >= 0; i--){ // [note] Index of last non-leaf : (size/2)-1
            minHeapify(i);
        }
    }
    // update value
    public void decreaseKey(int i, int x) { // index,value
        Heap[i]=x;// update value
        while(Heap[i] < Heap[parent(i)]){// same as insert // (i!=0 && Heap[i] < Heap[parent(i)])
            swap(i, parent(i));
            i=parent(i);
        }
    }
//    public void Delete(int i){
//        decreaseKey(i, Integer.MIN_VALUE);
//        remove();
//    }
    public void print(){
        for (int i = 0; i <= (size/2)-1 ; i++) {// [note] Index of last non-leaf Singly.node : (size/2)-1
            System.out.print("Parent : " + Heap[i]);
            if (left(i) < size)
                System.out.print("  Left : " + Heap[left(i)]);
            if (right(i) < size)
                System.out.print("  Right :" + Heap[right(i)]);
            System.out.println();
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (2 * i) + 1;
    }

    private int right(int i) {
        return (2 * i) + 2;
    }

    private boolean isLeaf(int i) {
        return right(i) >= MaxSize || left(i) >= MaxSize;
    }

    private void swap(int x, int y) {
        int temp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = temp;
    }
}