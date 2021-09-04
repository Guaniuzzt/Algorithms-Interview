import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args){


        int[] testarray = new int[]{1,5,7,2,3,6,5,8,4};
        System.out.println(Arrays.toString(heapsort(testarray)));
    }


    public static int[] heapsort(int[] input){

        if(input == null || input.length <= 1){
            return input;
        }

        for(int end=input.length-1; end>=0; end--){



        }


        return input;
    }


    public static void adjustheap (int[] array, int end){

        int left = end / 2 + 1;
    }




}
