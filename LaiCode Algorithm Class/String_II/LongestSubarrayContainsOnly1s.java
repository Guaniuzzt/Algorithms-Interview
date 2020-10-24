public class LongestSubarrayContainsOnly1s {

    public static void main(String[] args) {

        int[] test = new int[]{1,1,0,0,0,1,1,1};
        int k= 2;
        System.out.print(longestConsecutiveOnes(test, k));

    }


    public static int longestConsecutiveOnes(int[] nums, int k) {
        // Write your solution here

        if(nums == null || nums.length ==0)
            return 0;

        int fast = 0;
        int slow = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        while(fast < nums.length){
            if(nums[fast] == 1){
                max = Math.max(fast - slow + 1, max);
                fast++;

            }else{
                if(count < k){
                    count++;
                    max = Math.max(fast - slow + 1, max);
                    fast++;

                }else{
                    while(nums[slow] != 0){
                        slow++;
                    }
                    slow++;
                    count--;
                }
            }
        }

        return max;
    }
}
