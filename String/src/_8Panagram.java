public class _8Panagram {
    public static boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        int[] count=new int[26];
        for(int i=0; i<s1.length(); i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<s1.length(); i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("aaacb","cabaa"));//true
        System.out.println(isAnagram("amazon","aws"));//false
        System.out.println(isAnagram("nl","cx"));//false
    }
}
