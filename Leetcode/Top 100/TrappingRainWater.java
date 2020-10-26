public class TrappingRainWater {

    //42
    public int trap(int[] height) {

        int l = 0;
        int r = height.length - 1;

        while(l < r && height[l] <= height[l + 1]) l++;
        while(l < r && height[r-1] >= height[r]) r--;
        int res = 0;

        while(l < r){
            int left = height[l];
            int right = height[r];

            if(left <= right){
                while(l < r && height[l] <= left){
                    res = res  + (left - height[l]);
                    l++;
                }
            }else{
                while(l < r && height[r] <= right){
                    res += right - height[r];
                    r--;
                }
            }
        }
        return res;
    }
}
