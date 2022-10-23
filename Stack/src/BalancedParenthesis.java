import java.util.ArrayDeque;
import java.lang.String;
public class BalancedParenthesis {
    public boolean isMatch(char a,char b){
        return ( (a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}') );
    }
    public boolean isBalanced(String str) {
        ArrayDeque<Character> s=new ArrayDeque<Character>();
        for(int i=0; i<str.length(); i++){
            char c=str.charAt(i);
            if(c=='('||c=='['||c=='{'){
                s.push(c);
            }
            else{
                if(c==')'||c==']'||c=='}'){
                    if(s.isEmpty() || !isMatch(s.peek(), c))
                        return false;
                    else
                        s.pop();
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        BalancedParenthesis b=new BalancedParenthesis();
        String s="public static void main(String[] args)";
//        String s=""{[]}"";
        System.out.println(b.isBalanced(s));
    }
}
