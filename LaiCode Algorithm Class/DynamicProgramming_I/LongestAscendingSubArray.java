

public class LongestAscendingSubArray {

    /*
    Given an unsorted array,
    find the length of the longest subarray in which the numbers are in ascending order.

    Assumptions:
    The given array is not null
    Examples:
    {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
    {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
     */

    public static void main(String[] args) {
        int[] test = new int[]{7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(method(test));
        System.out.println(method1(test));
    }

    public static int method(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1)
            return 1;

        int[] dp = new int[array.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<array.length; i++){
            if(array[i] > array[i-1]){
                dp[i] = dp[i-1] + 1;
                max = Math.max(max, dp[i]);
            }else{
                dp[i] = 1;
            }
        }
        return max;
    }

    //followup
    public static int method1(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1)
            return 1;


        int pre = 1;
        int cur ;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<array.length; i++){
            if(array[i] > array[i-1]){
                cur = pre + 1;
                max = Math.max(max, cur);
            }else{
                cur = 1;
            }
            pre = cur;
        }
        return max;
    }


}
