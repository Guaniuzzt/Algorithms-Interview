import java.util.Arrays;
import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {

        int[] array = new int[]{3,5,1,5,7,2};
        method(array);
        System.out.println(Arrays.toString(array));
    }


    public static void method(int[] array){
        if(array == null || array.length == 0){
            return  ;
        }
        helper(array, 0, array.length - 1);
    }


    public static void helper(int[] array, int left, int right){

        if(left >= right)
            return ;

        Random rand = new Random();
        int pivot = left + rand.nextInt(right - left + 1);
        swap(array, pivot, right);

        int i = left;
        int j = right - 1;

        while(i <= j){
            if(array[i] >= array[right]){
                swap(array, i, j--);
            }else {
                i++;
            }
        }
        swap(array, i, right);
        helper(array, left, i-1);
        helper(array, i+1, right);
    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
