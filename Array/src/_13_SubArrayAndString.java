//  program to generate all possible subArrays/substring
public class _13_SubArrayAndString {
    /**
     *** SubArray(Substring) = n*(n+1)/2
     *** Subseqeunce = (2^n) -1 (non-empty subsequences)
     *** Subset(power set) = 2^n

     consider an array : {1,2,3,4}

     subArray(Substring) : contiguous sequence in an array i.e.  {1,2},{1,2,3}
     Subset(power set): Same as subsequence except it has empty set i.e. {1,3},{}
     Subsequence: Need not be contiguous, but maintains order i.e. {1,2,4}
     */
    // Prints all subArrays in arr[0..n-1]
    public static void subArray(int[] arr){    // TC : O(n^3)
        // Pick starting point
        for (int i = 0; i < arr.length; i++){
            // Pick ending point
            for (int j = i; j < arr.length; j++){
                // Print subArray between current starting and ending points
                for (int k = i; k <= j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void subString(String s){    // TC : O(n^3)
        // Pick starting point
        for(int i = 0; i < s.length(); i++){
            // Pick ending point
            for(int j = i; j < s.length(); j++){
                // print
                String temp = "";
                for(int k = i; k <= j; k++){
                    temp += s.charAt(k);
                }
                System.out.print(temp +" ");
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("All Non-empty SubArrays");
        subArray(arr);

//        subString("ABC");


//        String a = "parth" , b = "parth";
//        StringBuilder c = new StringBuilder();
//        c.append("tparth");
//        System.out.println(c);
//        c.delete(0,1);
//        if(a.equals(String.valueOf(c))){
//            System.out.println("yes");
//        }
    }
}

