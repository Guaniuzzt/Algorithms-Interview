import java.util.ArrayList;
import java.util.List;

/*
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
get all the possible ways to pay a target number of cents.
 */

public class CombinationsOfCoins {

    public static void main(String[] args) {
        int target = 99;
        int[] coins = new int[]{1,5,15,20};
        System.out.println(combinations(105,coins));
    }


    public static List<List<Integer>> combinations(int target, int[] coins) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, target, 0, coins);
        return res;

    }

    public static void dfs(List<List<Integer>> res, List<Integer> temp, int remains, int index, int[] coins){

        if(index == coins.length){
            if(remains == 0){
                res.add(new ArrayList<>(temp));
            }
            return ;
        }

        for(int i=0; i < remains / coins[index]; i++){
            temp.add(i);
            dfs(res, temp, remains - i * coins[index], index+1, coins);
            temp.remove(temp.size() - 1);
        }


    }


}
