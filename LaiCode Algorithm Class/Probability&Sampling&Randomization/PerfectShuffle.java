import java.util.Random;

public class PerfectShuffle {

    /*
    Given an array of integers (without any duplicates)
    , shuffle the array such that all permutations are
    equally likely to be generated.
     */

    public void shuffle(int[] array){
        if(array == null || array.length == 0){
            return ;
        }

        Random rand = new Random();
        int lastindex = array.length - 1;

        for(int i=0; i<array.length; i++){
            int index = i + rand.nextInt(lastindex - i + 1);
            swap(array, i, index);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
