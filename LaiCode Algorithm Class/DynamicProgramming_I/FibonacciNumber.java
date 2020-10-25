public class FibonacciNumber {

    /*
    Examples
    0th fibonacci number is 0
    1st fibonacci number is 1
    2nd fibonacci number is 1
    3rd fibonacci number is 2
    6th fibonacci number is 8
     */

    public static void main(String[] args) {
        System.out.println(method(6));
        System.out.println(followup(6));
    }

    public static long method(int k){
        if(k == 0)
            return 0;
        if(k == 1)
            return 1;

        long[] dp = new long[k+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<k+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[k];
    }
    //how to narrow down space to O(1)
    //Time: O(n)
    public static long followup(int k){
        if(k == 0)
            return 0;
        if(k == 1)
            return 1;

        long pre = 1;
        long prepre = 0;
        long cur = 0;
        for(int i=2; i<k+1; i++){
            cur = pre + prepre;
            prepre =pre;
            pre = cur;

        }

        return cur;
    }



}
