import java.util.ArrayDeque;
import java.util.Deque;

public class SortWith2Stack {

    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        for(int i=0; i<10; i++){
            deque1.offerLast(i);
        }
        method(deque1);

        while(!deque1.isEmpty()){
            System.out.println(deque1.pollLast());
        }

    }


    public static void method(Deque<Integer> deque1){

        Deque<Integer> deque2 = new ArrayDeque<>();


        while(!deque1.isEmpty()){
            int min = Integer.MAX_VALUE;   //every iteration need to set min to Integer.MAX_VALUE
            int count = 1;
            while(!deque1.isEmpty()){
                int temp = deque1.pollLast();
                if(temp < min){
                    count = 1;
                    min = temp;
                }else if(temp == min){
                    count++;
                }
                deque2.offerLast(temp);
            }

            while(!deque2.isEmpty() && deque2.peekLast() >= min){
                int temp = deque2.pollLast();
                if(temp > min){
                    deque1.offerLast(temp);
                }
            }

            for(int i=0; i<count; i++){
                deque2.offerLast(min);
            }
        }

        while(!deque2.isEmpty()){
            deque1.offerLast(deque2.pollLast());
        }
    }
}
