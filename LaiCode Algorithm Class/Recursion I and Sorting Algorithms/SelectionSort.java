import java.util.Arrays;

//Time: O(n^2)
//Space:O(1)


public class SelectionSort {


    public static void main(String[] args) {
        int[] array = new int[]{3,5,1,5,7,2};
        method(array);
        System.out.println(Arrays.toString(array));
    }


    public static void method(int[] array){

        if(array == null || array.length == 0)
            return;
        for(int i=0; i<array.length; i++){

            int min = i;
            int j = i + 1;
            while(j < array.length){

                if(array[j] < array[min]){
                    min = j;
                }
                j++;
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }
}
