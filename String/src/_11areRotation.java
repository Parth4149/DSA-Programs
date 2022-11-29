// Check if Strings are Rotations
public class _11areRotation {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {// time theta(n) , space theta(n) because concatenation of str1 and str2 takes theta(n) space
            return false;
        }
        return (s1 + s1).contains(s2); // OR  (s1+s1).indexOf(s2)>=0; //  without using library function, return contains((s1+s1),s2);
    }

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(areRotations(s1, s2));
    }
}