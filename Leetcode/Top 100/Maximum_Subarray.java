public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //Space: O(1)
    public int followup(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1){
            return nums[0];
        }

        int pre = nums[0];
        int max = pre;
        int cur;
        for(int i=1; i<nums.length; i++){
            if(pre <= 0){
                cur = nums[i];
                max = Math.max(cur, max);
                pre = cur;
            }else{
                cur = nums[i] + pre;
                max = Math.max(cur, max);
                pre = cur;
            }
        }
        return max;

    }

}
