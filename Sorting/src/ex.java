import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex {
//    public static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C){
//        ArrayList<Integer> resList = new ArrayList<>();
//
//        int[] res = intersectionOf2Arrays(intersectionOf2Arrays(A, B), C);
//        for(int i = 0; i < res.length; i++){
//            resList.add(res[i]);
//        }
//        System.out.println(resList);
//        return resList;
//    }
    public static List<Integer> commonElements(int[][] nums){ // TC : theta(n) * theta(m + n) , SC : theta(c)
        ArrayList<Integer> resList = new ArrayList<>();                                         // where c is no. of common elements

        // initialize first row(arr) as res
        int[] res = nums[0];

        for(int i = 1; i < nums.length; i++){
            res = intersectionOf2Arrays(res, nums[i]);
        }
        // store res into List
        for(int i = 0; i < res.length; i++){
            resList.add(res[i]);
        }
        System.out.println(resList);
        return resList;
    }
    public static int[] intersectionOf2Arrays(int[] A, int[] B){ // TC : theta(m + n) , SC : theta(c)
        ArrayList<Integer> list = new ArrayList<>();                                            // where c is no. of common elements
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            if(A[i] == B[j]){
                list.add(A[i]);
                while(i < (A.length - 1) && A[i] == A[i + 1]){
                    i++;
                }
                while(j < (B.length - 1) && B[j] == B[j + 1]){
                    j++;
                }
                i++; j++;
            }
            else if(A[i] < B[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

//    public static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3){
//        ArrayList<Integer> resList = new ArrayList<>();
//        int i = 0, j = 0, k = 0;
//        while(i < n1 && j < n2 && k < n3){
//            if(A[i] == B[j] && A[i] == C[k]){
//                System.out.println(A[i]);
//                resList.add(A[i]);
//                // handling duplicate element
//                while(i < (A.length - 1) && A[i] == A[i + 1]){
//                    i++;
//                }
//                while(j < (B.length -1) && B[j] == B[j + 1]){
//                    j++;
//                }
//                while(k < (C.length - 1) && C[k] == C[k + 1]){
//                    k++;
//                }
////                i++; j++; k++;
////                continue; // here we are incremented i,j & k , so that we move to next iteration
//            }               // to handle the next elements i,j & k they might be same
//            if(A[i] < B[j]){
//                i++;
//            }
//            if(B[j] < C[k]){
//                j++;
//            }
//            else{
//                k++;
//            }
//        }
//        return resList;
//    }
    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {1,2,3};
        int[] a3 = {1,2,3};
//        int[][] nums = {{1,2,3},{1,2,2},{1,5,9}};//1
        int[][] nums = {{1,2,3},{1,2,3},{1,2,3}};
        commonElements(nums);
//        commonElements(a1, a2, a3);
//        intersectionOf2Arrays(a1,a2);
    }
}
