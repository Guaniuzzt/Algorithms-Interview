import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {

    /*
    和I不同的地方时输入可以有相同值 eg: abc vs aabbcc 需要排除相同情况

     */

    public static void main(String[] args) {
        String test = "abc";
        System.out.println(method(test));
    }



    public static List<String> method(String input){
        List<String> list = new ArrayList<>();
        if(input == null || input.length() == 0)
            return list;

        char[] array = input.toCharArray();
        boolean[] flag = new boolean[array.length];
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(array, sb, set, list, flag, 0);
        return list;


    }


    public static void dfs(char[] array, StringBuilder sb,Set<String> set, List<String> list, boolean[] flag, int index){

        if(index == array.length){
            String temp = new String(sb);
            if(set.add(temp))
                list.add(temp);
            return ;
        }

        for(int i=0; i<array.length; i++){
            if(!flag[i] ){
                sb.append(array[i]);
                flag[i] = true;
                dfs(array, sb, set, list,  flag, index+1);
                sb.deleteCharAt(sb.length()-1);
                flag[i] = false;
            }
        }

    }





}
