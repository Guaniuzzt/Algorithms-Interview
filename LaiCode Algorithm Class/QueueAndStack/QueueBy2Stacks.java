import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBy2Stacks {

    Deque<Integer> deque1 = new ArrayDeque<>();
    Deque<Integer> deque2 = new ArrayDeque<>();

    public int size(){
        return deque1.size() + deque2.size();
    }

    public Integer peek(){
        if(deque1.isEmpty()){
            while(!deque2.isEmpty()){
                deque1.offerLast(deque2.pollLast());
            }
        }

        if(deque1.peekLast() == null)
            return null;
        return deque1.peekLast();
    }

    public void offer(int value){
        deque2.offerLast(value);
    }

    public Integer poll(){
        if(deque1.isEmpty()){
            while(!deque2.isEmpty()){
                deque1.offerLast(deque2.pollLast());
            }
        }
        if(deque1.peekLast() == null)
            return null;
        return deque1.pollLast();
    }



    public static void main(String[] args) {
        QueueBy2Stacks queue = new QueueBy2Stacks();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }



}
