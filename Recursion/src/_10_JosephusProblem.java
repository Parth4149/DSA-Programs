public class _10_JosephusProblem {
    // T(n) = T(n-1) + C
    // time : theta(n)
    /**
     * problem is :
     * (When we kill k-th person, n-1 persons are left, but numbering starts from k+1 and goes in modular way.)
     * n number of people are stacked in war
     * they decide that we won't be killed by enemies
     * they discuss what we should do
     * one person suggest an idea that fist person will kill k'th person then (k+1)'th person will kill their k'th person and so on
     * at the end one person will be left then this person will su-side
     */
    // https://www.scaler.com/topics/josephus-problem/
    public static int jos(int n, int k){ // for 0 to n-1 order
        if(n == 1){
            return 0;
        }
        return (jos(n-1, k) + k) % n;
    }
    public static int myJos(int n, int k){
        // for 1 to n  order
        return jos(n, k) + 1;
    }

    public static void main(String[] args) {
        System.out.println(myJos(5,3)); // 4
        System.out.println(myJos(4,2)); // 1
        System.out.println(myJos(7,3)); // 4
    }
}
