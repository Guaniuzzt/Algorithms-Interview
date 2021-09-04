public class RainbowSort {


    /*
    Time: O(n)
    Space: O(1)
     */

    public int[] rainbowSort(int[] array) {
        // Write your solution here

        if(array == null || array.length <= 1){
            return array;
        }

        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while(j <= k){
            if(array[j] == -1){
                swap(array, i, j);   //swap first 0 to this position and return -1 to that
                i++;
                j++;
            }else if(array[j] == 0){
                j++;
            }else{
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
