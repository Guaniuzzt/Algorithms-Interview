import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{3,5,1,5,7,2};
        System.out.println(Arrays.toString(method(array)));
    }

    public static int[] method(int[] array){

        if(array == null || array.length == 0){
            return array ;
        }

        int left = 0;
        int right = array.length - 1;

        return divide(array, left, right);
    }


    public static int[] divide(int[] array, int left , int right){

        if(left >= right)
            return new int[]{array[left]};

        int mid = left + (right - left)/2;
        int[] leftarray = divide(array, left, mid);
        int[] rightarray = divide(array, mid+1, right);

        return merge(leftarray, rightarray);

    }


    public static int[] merge(int[] array1, int[] array2){


        int[] res = new int[array1.length + array2.length];

        int cur = 0;
        int p1 = 0;
        int p2 = 0;

        while(p1 != array1.length && p2 != array2.length){

            if(array1[p1] < array2[p2]){
                res[cur++] = array1[p1++];
            }else{
                res[cur++] = array2[p2++];
            }

        }

        while(p1 != array1.length){
            res[cur++] = array1[p1++];
        }

        while(p2 != array2.length){
            res[cur++] = array2[p2++];
        }

        return res;

    }


}



