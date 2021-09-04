

import java.util.Arrays;

public class KClosestInSortedArray {


    public static void main(String[] args) {
        int[] test = new int[]{1,3,5};
        int[] res= method(test, 10, 3);

        System.out.println(Arrays.toString(res));
    }

    //return index
    public static int[] method(int[] array, int target, int k){
        // Write your solution here

        int[] result = new int[k];
        if(array == null || array.length == 0){
            return result;
        }

        if(array.length < k){
            k = array.length;
        }

        result = new int[k];

        int l = 0;
        int r = array.length - 1;
        int mid;

        while(l < r - 1){
            mid = l + (r - l)/2;
            if(array[mid] == target){
                r = mid;
            }else if(array[mid] > target){
                r = mid;
            }
            else{
                l = mid;
            }
        }

        for(int i=0; i<k; i++){
            if(l <0 ||
                    (r <= array.length - 1) &&  (Math.abs(target - array[l]) > Math.abs(target - array[r])) ){   // 此处(r <= array.length - 1)一定要在前面进行判断，如果放在后面会越界
                result[i] = array[r++];
            }else{
                result[i] = array[l--];
            }
        }

        return result;







    }
}
