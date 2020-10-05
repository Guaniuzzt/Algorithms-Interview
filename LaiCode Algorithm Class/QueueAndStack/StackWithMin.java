import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMin {


    Deque<Integer> stack;
    Deque<Integer> minstack;
    //int minvalue;

    public StackWithMin(){
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
        //minvalue = Integer.MAX_VALUE;
    }

    public void push(int element){
        stack.offerLast(element);
        if(minstack.isEmpty() || element <= minstack.peekLast()){
            minstack.offerLast(element);
        }
    }

    public Integer pop(){
        if(stack.isEmpty())
            return null;
        if(minstack.peekLast() == stack.peekLast()){
            minstack.pollLast();
        }
        return stack.pollLast();
    }

    public Integer min(){
        if(stack.isEmpty())
            return null;
        return minstack.peekLast();
    }


    public static void main(String[] args) {

        StackWithMin stack = new StackWithMin();
        stack.push(2);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }

}
