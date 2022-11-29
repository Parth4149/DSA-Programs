import java.util.Arrays;

//left most non repeating character
public class _10_LeftMostNon {
    // repeated -2 approach
    final static int CHAR = 256;

    public static int LeftMostNon(String s) { //[precise] theta(n+CHAR) , space : theta(CHAR) consider alphabet size is constant
        int[] fIndex = new int[CHAR];
        Arrays.fill(fIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if (fIndex[s.charAt(i)] == -1)
                fIndex[s.charAt(i)] = i;
            else
                fIndex[s.charAt(i)] = -2;// if char occurs again then it sets value=-2 (at char index)// repeating char's index is -2
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < CHAR; i++) {
            if (fIndex[i] >= 0)
                res = Math.min(res, fIndex[i]);// we can not write return i; because it returns index of d  (due to d comes first
        }                                     //  alphabetically), here we have to return index of p (due to it comes first in String)
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    //    public int LeftMostNon(String s){//  abcaa
//        int[] count=new int[CHAR];
//        int res=Integer.MAX_VALUE;
//        for(int i=0; i<s.length(); i++)
//            count[s.charAt(i)]++;
//        for(int i=0; i<s.length(); i++){
//            if(count[s.charAt(i)]==1)
//                return i;
//        }
//        return -1;
//    }
    public static void main(String[] args) {
        System.out.println(LeftMostNon("abbpda"));//3
        System.out.println(LeftMostNon("google"));//4
        System.out.println(LeftMostNon("abab"));//-1
    }
}
