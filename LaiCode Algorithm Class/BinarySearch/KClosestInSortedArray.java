package BinarySearch;

import java.util.Arrays;

public class KClosestInSortedArray {


    public static void main(String[] args) {
        int[] test = new int[]{1,2,5,6,10};
        int[] res= method(test, 5, 5);

        System.out.println(Arrays.toString(res));
    }

    //return index
    public static int[] method(int[] array, int target, int k){
        int[] res = new int[k];
        if(array == null || array.length == 0){
            return res;
        }

        int l = 0;
        int r = array.length - 1;

        while(l < r - 1){
            int mid = l + (r - l)/2;
            if(array[mid] == target){
                l = mid;
            }else if(array[mid] < target){
                l = mid;
            }else {
                r = mid;
            }
        }

        for(int m=0; m<k; m++){

            if(l < 0 || (r < array.length && Math.abs(array[l] - target) > Math.abs(array[r] - target))){
                res[m] = array[r++];
            }else{
                res[m] = array[l--];
            }
        }

        return res;







    }
}
