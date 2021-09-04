import java.util.ArrayList;
import java.util.List;

public class test2 {

    public static void main(String[] args) {

        int[] test = new int[]{1,2,3,4};
        List<Integer> list = new ArrayList<>();
        int max = 3;
        int[] res = new int[]{0};

        dfs2(test, 0, list, 3, res);

        System.out.print(res[0]);

    }


    public static void dfs(int[] array2, int index, List<Integer> list, int max, int[] res) {
//        if(index >= array2.length){
//            return;
//        }
        if(list.size() == 3){
            if(list.get(2) - list.get(0) <= max){
                res[0]++;
                System.out.println(list);
            }
            return ;
        }
//        if(list.size() > 3){
//            return ;
//        }

        for(int i=index; i<array2.length; i++){
            list.add(array2[i]);
            dfs(array2, index+1, list, max, res);
            list.remove(list.size()-1);
            dfs(array2, index+1, list, max, res);
        }
    }


    public static void dfs2(int[] array3, int index, List<Integer> list, int max, int[] res) {



        if(list.size() == 3){
            if(list.get(2) - list.get(0) <= max){
                res[0]++;
                System.out.println(list);
            }
            return ;
        }

        if(index >= array3.length)
            return ;

        list.add(array3[index]);
        dfs2(array3, index+1, list, max, res);
        list.remove(list.size()-1);
        dfs2(array3, index+1, list, max, res);

    }
}
