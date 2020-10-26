import java.util.ArrayDeque;
import java.util.Deque;

public class Valid_Parentheses {

    //20
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            if(stack.size() == 0){
                stack.offerLast(s.charAt(i));
            }else{
                char temp = s.charAt(i);
                if(temp == '(' || temp == '{' || temp == '['){
                    stack.offerLast(temp);
                }else if((temp == ')' && stack.peekLast() == '(') || temp == ']' && stack.peekLast() == '[' || temp == '}' && stack.peekLast() == '{'){
                    stack.pollLast();
                }else{
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
