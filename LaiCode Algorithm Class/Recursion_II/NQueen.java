import java.util.ArrayList;
import java.util.List;

public class NQueen {


    public static void main(String[] args) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, 4);
        System.out.print(res);

    }

    public static void dfs(List<List<Integer>> res, List<Integer> list, int n){

        if(list.size() == n){
            res.add(new ArrayList<>(list));
            return ;
        }

        for(int i=0; i < n; i++){
            if(checker(list, i)){
                list.add(i);
                dfs(res, list, n);
                list.remove(list.size() - 1);
            }

        }
    }

    public static boolean checker(List<Integer> list, int position){

        for(int i=0; i<list.size(); i++){
            if(list.get(i) == position || Math.abs(position - list.get(i)) == list.size() - i){
                return false;
            }
        }
        return true;
    }
}
