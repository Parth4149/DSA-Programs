import java.util.Arrays;

// Left most repeating character , return the index of left most repeating character
public class

_9LeftMost {
    // Efficient approach 1
    static final int CHAR=256;
    public static int leftMost(String s){//time : O(h+CHAR) , space : O(CHAR)
        boolean[] visited=new boolean[CHAR];
        int res=-1;
        for(int i=s.length()-1; i>=0; i--){
            if(visited[s.charAt(i)])
                res=i;
            else
                visited[s.charAt(i)]=true;
        }
        return res;
    }
    // Efficient approach 2
//    public static int leftMost(String s){//time : O(h+CHAR) , space : O(CHAR)
//        int[] fIndex=new int[CHAR];
//        Arrays.fill(fIndex,-1);
//        int res=Integer.MAX_VALUE;
//        for(int i=s.length()-1; i>=0; i--){
//            int fi=fIndex[s.charAt(i)];
//            if(fi==-1)
//                fIndex[s.charAt(i)]=i;// set , if the char repeat then else statement will execute
//            else
//                res=i;
//        }
//        return (res==Integer.MAX_VALUE) ? -1 : res;
//    }

/*
    final int CHAR=256;
    public int leftMost(String s){//
        int[] count =new int[CHAR];
        for(int i=0;i<s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int i=0; i<s.length(); i++){
            if(count[s.charAt(i)]>1)
                return i;
        }
        return -1;
    }
*/
    public static void main(String[] args) {
        int ans=leftMost("aebbcc");

        System.out.println(ans);
    }
}
