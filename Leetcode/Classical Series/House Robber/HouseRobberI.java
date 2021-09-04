import java.util.Arrays;

public class HouseRobberI {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(method(test));
    }



    public static int method(int[] array){

        if(array == null || array.length == 0){
            return 0;
        }

        int pre = 0;  //pre = dp[i-2]
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for(int i=1; i<array.length; i++){
            dp[i] = Math.max(dp[i-1], array[i] + pre);
            pre = dp[i-1];
        }
        return dp[dp.length - 1];

    }
}
