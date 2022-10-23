// check Kth bit is set or not
public class _4checkKthBitSet {
/**
 // Method 1
    public static void KthBit(int n,int k){   // left shift
        if((n & (1 << (k-1)) ) != 0){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
*/

// Method 2
    public static void KthBit(int n, int k){    // right shift
        if(((n >> (k-1)) & 1) == 1){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
//(in right shift) n=5 and k=3 : 101>>2 -> 001 => (001 & 1) == 1 then print "yes"
    public static void main(String[] args) {
        KthBit(5,3);//00...101 and 1 moves twice left ,(101 & 100) = 4 (!= 0) then print "Yes"
        KthBit(8,2);//00...1000 ,   (1000 & 0010) -> "No"
        KthBit(8,4);//00...1000,    (1000 & 1000) -> "Yes"
        KthBit(0,3);//00...000,    (000 & 100) -> "No"
    }
}
