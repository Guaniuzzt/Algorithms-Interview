public class Best_Time_to_Buy_and_Sell_Stock {

    //121
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {

            if (price < min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }
        return res;

    }
}
