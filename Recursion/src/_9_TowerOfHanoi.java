public class _9_TowerOfHanoi {

    // T(n) = 2T(n - 1) + 1
    public static void TOH(int n,char A,char B,char C){ // TC : O(2^n) , SC : O(h)  height of tree OR [O(n) recursion call stack]
        if(n <= 0){
            return;
        }
        // move top n-1 disks from A to B using C as an auxiliary(reference)
        TOH(n - 1, A, C, B);

        // move remaining disk from A to C
        System.out.println("move disk from "+A+" -> "+C);   // this line is only execute after remove left fun call from the stack

        // move n-1 disks from B to C using A as auxiliary
        TOH(n - 1, B, A ,C);
    }
    public static void main(String[] args) {
        TOH(3,'A','B','C');
    }
}
