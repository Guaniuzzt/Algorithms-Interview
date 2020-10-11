import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {

    public static void main(String[] args) {
        String test = "abc";
        System.out.println(permutations(test));
    }

    public static  List<String> permutations(String input) {

        List<String> res = new ArrayList<>();
        if(input == null  || input.length() == 0)
            return res;
        boolean[] check = new boolean[input.length()];
        StringBuilder sb = new StringBuilder();
        dfs(res, input, 0, check, sb);
        return res;
    }


    public static void dfs(List<String> res, String input, int index, boolean[] check, StringBuilder sb){

        if(index == input.length()){
            String temp = new String(sb);
            res.add(temp);
            return ;
        }

        for(int i=0; i<input.length(); i++){
            if(!check[i]){
                sb.append(input.charAt(i));
                check[i] = true;
                dfs(res, input, index+1, check, sb);
                check[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }


    }
}
