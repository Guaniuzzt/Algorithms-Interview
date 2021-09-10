import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {


    private PriorityQueue<Integer> smallerHalf;
    private PriorityQueue<Integer> largerHalf;

    public MedianTracker() {
        // add new fields and complete the constructor if necessary.
        largerHalf = new PriorityQueue<Integer>();
        smallerHalf = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void read(int value) {
        // write your implementation here.
        if(smallerHalf.isEmpty() || value <= smallerHalf.peek()){
            smallerHalf.offer(value);
        }else{
            largerHalf.offer(value);
        }

        if(smallerHalf.size() - largerHalf.size() >= 2){
            largerHalf.offer(smallerHalf.poll());
        }else if(largerHalf.size() > smallerHalf.size()){
            smallerHalf.offer(largerHalf.poll());
        }
    }


    public Double median() {
        // write your implementation here.

        int size = size();
        if(size == 0){
            return null;
        }else if(size % 2 == 0){
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        }else{
            return (double)smallerHalf.peek();
        }
    }


    private int size(){
        return smallerHalf.size() + largerHalf.size();
    }
}
