import java.util.Arrays;

public class QuickSelectKthSmallestLearn {


    public static void main(String[] args) {

        int k = 8;
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickselectres(arr, 0, arr.length - 1, k - 1);
    }


    public static int[] quickselectres(int[] array, int low , int high, int k){
        int j = partition(array, low, high);
        if(j == k)
            return Arrays.copyOf(array, j+1);
        else
            return j > k ? quickselectres(array, low, j-1, k) : quickselectres(array, j+1, high, k);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = quickselect(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }


    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }


//    public static int[] method(int[] array, int k){
//        if(array == null || array.length == 0 || k == 0)
//            return new int[0];
//
//        if(array.length < k)
//            return array;
//
//        int low = 0;
//        int high = array.length -1;
//
//        int position = partition(array, low, high);
//        while(true){
//            if(position == k- 1)
//                break;
//            else if(position < k-1)
//                partition(array, position+1, high);
//            else
//                partition(array, low, position-1);
//        }
//
//        return Arrays.copyOf(array, k);
//    }
//
//
//    public static int[] method2(int[] array , int k){
//
//        if(array == null || array.length == 0 || k == 0)
//            return new int[0];
//
//        if(array.length < k)
//            return array;
//
//        return quickselectres(array, 0, array.length-1, k-1);
//    }




    public static int quickselect(int[] array, int low, int high){

        int pviot = array[low];
        int i = low;
        int j = high;

        while(i <= j ){
            if(array[i] <= pviot){
                i++;
            }else{
                swap(array, i, j);
                j--;
            }
        }
        swap(array, low, j);
        return j;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
