import java.util.Arrays;

public class RainbowSort {

    public static void main(String[] args) {
        int[] array = new int[]{-1, -1, 1, 0, -1, 1, 0};
        method(array);
        System.out.println(Arrays.toString(array));
    }


    public static void method(int[] array){

        if(array == null || array.length == 0)
            return;

        int i = 0;
        int j = 0;
        int k = array.length - 1;

        while(j <=k){
            if(array[j] == -1){
                swap(array, i, j);
                i++;
                j++;
            }else if(array[j] == 0){
                j++;
            }else{
                swap(array, j, k);
                k--;
            }

        }

    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
