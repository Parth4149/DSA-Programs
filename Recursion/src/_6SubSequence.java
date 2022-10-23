import java.util.ArrayList;
import java.util.List;

public class _6SubSequence {

    // Declare a global list
    static List<String> al = new ArrayList<>();
    public static void findSubsequences(String s,String ans) {
        if(s.length() == 0) {
            al.add(ans);
            return;
        }

        // We add 1st character in string
        findSubsequences(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string because the concept of subsequence either character will present or not
        findSubsequences(s.substring(1), ans);
    }

    public static void skipA(String curr, String res){// time : O(n) , space : O(n)
        if(curr.isEmpty()){
            System.out.println(res);
            return;
        }
        char ch = curr.charAt(0);
        if(curr.charAt(0) == 'a'){
            skipA(curr.substring(1),res);
        }
        else{
            skipA(curr.substring(1),res + ch);
        }
    }
    public static String skipA(String curr){
        if(curr.isEmpty()){
            return "";
        }
        int ch = curr.charAt(0);
        if(ch == 'a'){
            return skipA(curr.substring(1));
        }
        else{
            return ch + skipA(curr.substring(1));
        }
    }

//--------------------------------------------------------
    public static String skipApple(String curr){
        if(curr.isEmpty()){
            return "";
        }
        char ch = curr.charAt(0);
        if(curr.startsWith("apple")){
            return skipApple(curr.substring(5));
        }
        else{
            return ch + skipApple(curr.substring(1));
        }
    }
    public static String skipString(String curr,String targetString){
        if(curr.isEmpty()){
            return "";
        }
        char ch = curr.charAt(0);
        if(curr.startsWith(targetString)){
            return skipString(curr.substring(targetString.length()), targetString);
        }
        else{
            return ch + skipString(curr.substring(1),targetString);
        }
    }
    //--------------------------------------------------------
    public static void printAllSubstrings(String str) { // Substring = SubArray
        int n = str.length();
        // consider all substrings starting from `i`
        for (int i = 0; i < n; i++){
            // consider all substrings ending at j
            for (int j = i; j < n; j++){
                System.out.print("'" + str.substring(i, j + 1) + "', ");
            }
        }
    }
    //------------------------------------------------------------
    public static void main(String[] args){
//        skipA("Prajapati Parth","");
//        System.out.println(skipA("bcaddap"));
//        System.out.println(skipApple("bccdappledfg"));
//        System.out.println(skipString("i am software engineer, i am fire, i will be working at product base company", "am"));
//        System.out.println(skipString("Prajapati Parth , ", "Praj"));

        String s = "abc";
        findSubsequences(s, ""); // Calling a function
        System.out.println(al);
    }
}
