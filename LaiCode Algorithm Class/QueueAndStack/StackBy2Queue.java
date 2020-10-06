import java.util.ArrayDeque;
import java.util.Deque;

public class StackBy2Queue {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    public void push(int element){
        queue1.offerLast(element);
    }

    public Integer pop(){
        Integer pre = queue1.pollFirst();
        Integer cur = queue1.pollFirst();
        while(cur != null){
            queue2.offerLast(pre);
            pre = cur;
            cur = queue1.pollFirst();
        }
        queue1 = queue2;
        queue2 = new ArrayDeque<>();

        return pre;
    }

    public Integer top(){
        Integer temp = pop();
        if(temp != null){
            queue1.offerLast(temp);
        }
        return temp;
    }

    public boolean isEmpty(){
        return top() == null;
    }
}

