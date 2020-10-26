public class HouseRobberII {


    public static void main(String[] args) {

        int[] test = new int[]{2,3,2};
        System.out.println(method(test));

    }


    public static int method(int[] array){


        if(array == null || array.length == 0)
            return 0;

        if(array.length == 1){
            return array[0];   //一定要进行判断 因为后面有对dp[dp.length - 2]进行取值
        }


        int[] dp = new int[array.length];
        //choose first house
        dp[0] = array[0];
        int pre = 0;
        for(int i=1; i<dp.length-1; i++){
            dp[i] = Math.max(dp[i-1], array[i] + pre);
            pre = dp[i-1];
        }

        int max = dp[dp.length -2];
        dp[0] = 0;
        pre = 0;
        for(int i=1; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1], array[i] + pre);
            pre = dp[i-1];
        }
        return Math.max(dp[dp.length-1], max);


    }
}
