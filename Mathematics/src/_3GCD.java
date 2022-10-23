public class _3GCD {
/*
    public static int FindGCD(int a,int b){    //Naive solution // time : O(min(a,b))
        int c=Math.min(a,b);
        while(c>0){
            if(a%c==0 && b%c==0){
                return c;
            }
            c--;
        }
        return 1;
    }
*/
/*
    public static int FindGCD(int a,int b){// Basic Euclidean Algorithm
        while(a!=b){
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;
    }
*/
// Euclidean Algorithm Optimized implementation
    public static int FindGCD(int a,int b){// time : O[log(min(a,b))]
        if(b==0){
            return a;
        }
        else{
            return FindGCD(b,a%b);
        }
    }
    public static void main(String[] args) {
        System.out.println(FindGCD(4,6));
        System.out.println(FindGCD(7,13));
    }
}
