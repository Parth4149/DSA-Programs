// Check if Strings are Rotations
class Test11{
    public static boolean areRotations(String s1,String s2){
        if(s1.length()!=s2.length()){// time theta(n) , space theta(n) because concatenation of str1 and str2 takes theta(n) space
            return false;
        }
        return (s1+s1).contains(s2); // OR  (s1+s1).indexOf(s2)>=0; //  without using library function, return contains((s1+s1),s2);
    }
//    public static boolean contains(String s1,String s2){ // contains without using library function
//        int j=0;
//        for(int i=0; i<s1.length(); i++){
//            if(j==s2.length())
//                break;                        // in the case of index of then return (i - s2.length())
//            if(s1.charAt(i)==s2.charAt(j))
//                j++;
//        }
//        return (j==s2.length());
//    }
    public static void main(String[] args) {
        String s1="abcd",s2="cdab";
        System.out.println(areRotations(s1,s2));
    }
}