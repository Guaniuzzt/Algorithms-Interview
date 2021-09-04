import java.util.Random;

public class QuickSort {

    /*
    Time: average nlogn, worst n^2
    Space: logn, worst n
     */

    public int[] quickSort(int[] array) {
        // Write your solution here

        if(array == null || array.length <= 1){
            return array;
        }

        helper(array, 0, array.length - 1);
        return array;
    }


    public static void helper(int[] array, int left, int right){

        if(left >= right){
            return ;
        }
        Random rand = new Random();
        int pviot = left + rand.nextInt(right - left + 1);
        swap(array, pviot, right);

        int l = left;
        int r = right - 1;
        while(l <= r){
            if(array[r] >= array[right]){
                r--;
            }else{
                swap(array, l++, r);
            }
        }
        swap(array, l, right);
        helper(array, left, l-1);    //watch out: the bound here should be l-1, not pviot,
        helper(array, l+1, right);    //pviot just pick a random value, left and right index not stop at pviot
        return ;
    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
