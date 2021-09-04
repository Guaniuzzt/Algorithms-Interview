import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

    /*
    利用map来左sliding window
    Space: O(N)
    Time: O(N)
     */

    public static void main(String[] args) {
        String pattern = "aab";
        String input = "ababacbbaac";  // 0 3 8 18
        System.out.println(method(pattern, input));
    }

    public static List<Integer> method(String sh, String lo){

        /*List<Integer> res = new ArrayList<>();
        if(input == null || input.length() ==0)
            return res;

        Map<Character, Integer> map = helper(pattern);
        int size = map.size();
        int match = 0;

        for(int i=0; i<input.length(); i++){

            if(map.containsKey(input.charAt(i))){    //遍历，把包含在map里的字符吐出去
                int count = map.get(input.charAt(i));
                if(count == 1){                      //吐到只剩最后一个，说明这个字符都match
                    match++;
                }
                map.put(input.charAt(i), count-1);
            }
            // 0 1 2 3

            if(i >= pattern.length()){      // i>=pattern.length() 说明 i-pattern.length() 已经不在sliding window内
                                            // 当index 长度超过 pattern需要把sliding window没有包含的字符再吃回map
                if(map.containsKey(input.charAt(i-pattern.length()))){
                    int count = map.get(input.charAt(i-pattern.length()));
                    if(count == 0){
                        match--;
                    }
                    map.put(input.charAt(i-pattern.length()), count + 1);
                }
            }

            if(match == size){          //match数量==map.size() 符合条件
                res.add(i - pattern.length() + 1);
            }

        }

        return res;*/

        List<Integer> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<sh.length(); i++){
            char temp = sh.charAt(i);
            map.put(temp, map.get(temp)  == null ? 1 : map.get(temp) + 1 );
        }

        int match = 0;
        int size = map.size();

        for(int i=0; i<lo.length(); i++){

            char temp = lo.charAt(i);
            Integer count = map.get(temp);
            if(count != null){
                map.put(temp, count-1);
                if(count == 1){
                    match++;
                }
            }

            if(i >= sh.length()){
                char pre = lo.charAt(i-sh.length());
                Integer countpre = map.get(lo.charAt(i-sh.length()));
                if(countpre != null){
                    map.put(pre, countpre+1);
                    if(countpre == 0){
                        match--;
                    }
                }


            }

            if(match == size){
                list.add(i - sh.length() + 1);
            }
        }

        return list;




    }

    public static Map<Character, Integer> helper(String pattern){

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            int temp  = map.getOrDefault(pattern.charAt(i), 0);
            map.put(pattern.charAt(i), temp+1);
        }
        return map;
    }
}
