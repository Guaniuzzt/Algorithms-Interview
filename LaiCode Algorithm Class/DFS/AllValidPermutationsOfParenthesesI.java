import java.util.ArrayList;
import java.util.List;


/*
Time: O(2 ^ (2n) * n)
Space: O(2n)
 */

public class AllValidPermutationsOfParenthesesI {


    public static void main(String[] args) {
        System.out.println(method(3));
    }


    public static List<String> method(int n){

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, 0, 0, n);
        return list;
    }


    public static void dfs(List<String> list,StringBuilder sb, int left, int right, int n){

        if(left == n && right == n){
            String temp = new String(sb);
            list.add(temp);
            return ;
        }

        if(left < n){
            sb.append('(');
            dfs(list,sb, left+1, right, n);
            sb.deleteCharAt(sb.length() -1);
        }

        if(right < left){
            sb.append(')');
            dfs(list, sb, left, right+1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }





}
