public class Decode_Ways {

    //93
    public static void main(String[] args) {

        String test = "10";
        System.out.println(numDecodings(test));

    }
    public static int numDecodings(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<dp.length; i++){
            //check single digit decode is possible or not
            if(s.charAt(i-1) != '0'){     //在这里把'0' 写成 0 并且 debug半小时到捶自己大腿的应该没人了把
                dp[i] += dp[i-1];
            }

            int twodigit = Integer.parseInt(s.substring(i-2, i));
            if(twodigit >= 10 && twodigit <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }
}
