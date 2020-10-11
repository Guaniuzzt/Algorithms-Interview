import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    /*

    Given a set of characters represented by a String,
    return a list containing all subsets of the characters.

    Assumptions
    There are no duplicate characters in the original set.

    Examples
    Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
    Set = "", all the subsets are [""]
    Set = null, all the subsets are []
     */

    /*

    Time: O(n * 2^n + 2 ^ n)   2^n最后一层的个数 ， n打印， 2 ^n node个数
    Space: O(n) recursion tree 高度。
     */

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        String test = "abc";
        char[] testarray = test.toCharArray();
        dfs(list, sb,testarray, 0);
        System.out.println(list);
    }


    public static void dfs(List<String> list, StringBuilder sb, char[] chararray, int index){

        if(index == chararray.length){
            String temp = new String(sb);
            list.add(temp);
            return ;
        }

        sb.append(chararray[index]);
        dfs(list, sb, chararray, index+1);
        sb.deleteCharAt(sb.length() - 1);
        dfs(list, sb, chararray, index+1);
    }

}
