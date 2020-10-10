import java.util.Arrays;

public class QuickSelectKthSmallestDebug {

    public static void main(String[] args) {

        int k = 8;
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));

    }


    public static int[] getLeastNumbers(int[] arr, int k) {

        if(arr == null || arr.length == 0 || k == 0 )
            return new int[0];
        if(arr.length < k)
            return arr;

        int low = 0;
        int high = arr.length - 1;
        int position = helper(arr, low, high);

        while(true){
            if(position == k-1)
                break;
            else if(position < k-1) {
                low = position + 1;
                position = helper(arr, low, high);
            }
            else{
                high = position - 1;
                position = helper(arr, low, high);
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = arr[i];
        }

        return res;
    }

    public static int helper(int[] arr, int low, int high){
        int flag = arr[low];
        int i = low;
        int j = high;

        while(i <= j){
            if(arr[i] <= flag){
                i++;
            }else{
                swap(arr, i, j);
                j--;
            }
        }
        swap(arr, j, low);
        return j;
    }

    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


