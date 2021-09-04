public class MergeSort {


    /*
    Time: nlogn
    Space: (n + logn) => n
     */

    public int[] mergeSort(int[] array) {
        // Write your solution here

        if(array == null || array.length <= 1){
            return array;
        }
        int[] result = helper(array, 0, array.length - 1);
        return result;
    }


    public static int[] helper(int[] array, int i, int j){

        if(i == j){
            return new int[]{array[i]};    // this line is very important, must return new array
        }
        int mid = i + (j - i)/2;
        int[] left = helper(array, i, mid);
        int[] right = helper(array, mid+1, j);

        return merge(left, right);
    }


    public static int[] merge(int[] left, int[] right){

        int[] result = new int[left.length + right.length];

        int curl = 0;
        int curr = 0;
        int cur = 0;

        while(curl != left.length && curr != right.length){

            if(left[curl] <= right[curr]){
                result[cur++] = left[curl++];
            }else{
                result[cur++] = right[curr++];
            }
        }

        while(curl < left.length){
            result[cur++] = left[curl++];
        }

        while(curr < right.length){
            result[cur++] = right[curr++];
        }

        return result;

    }
}
