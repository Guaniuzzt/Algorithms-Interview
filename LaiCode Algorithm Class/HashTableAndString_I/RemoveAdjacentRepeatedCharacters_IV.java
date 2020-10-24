import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentRepeatedCharacters_IV {

    public static void main(String[] args) {
        String test = "aababab";
        System.out.println(deDup(test));
    }


    public static String deDup(String input) {
        // Write your solution here

        if(input == null || input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        int index = 0;
        while(index != input.length()){
            if(deque.size() == 0){
                deque.offerLast(array[index++]);
            }else{
                if(array[index] == deque.peekLast()){
                    while(index != array.length && array[index] == deque.peekLast()){
                        index++;
                    }
                    deque.pollLast();
                }else{
                    deque.offerLast(array[index++]);
                }
            }
        }
        int size = deque.size();

        for(int j = size - 1; j>=0; j--){
            array[j] = deque.pollLast();
        }

        return new String(array, 0, size);
    }
}
