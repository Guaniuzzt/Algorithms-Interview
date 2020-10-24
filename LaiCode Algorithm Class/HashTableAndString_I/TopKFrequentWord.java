import java.util.*;


/*
Map.Entry<key, value> a collection view of Map
map.entrySet() return a set of Map.Entry<k, v>
map.size() return number of k-v pair in map
Map.Entry<k, v> o1;
o1.getValue();
o1.getKey();

Time: O(n+ nlogk+ k);
Space: O(n+ k)
 */

public class TopKFrequentWord {

    public static void main(String[] args) {
        String[] test = new String[]{"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        System.out.println(Arrays.toString(method(test, 5)));
    }


    public static String[] method(String[] input, int k){
        String[] res = new String[k];
        if(input == null || input.length == 0){
            return res;
        }


        Map<String, Integer> map = new HashMap<>();
        for(String str : input){
            int times = map.getOrDefault(str, 0);
            map.put(str, times + 1);
        }

        if( k > map.size()){
            k = map.size();
        }

        res = new String[k];

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return 0;
                }
                return o1.getValue() < o2.getValue() ? -1 : 1;
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(pq.size() < k)
                pq.offer(entry);
            else{
                if(pq.peek().getValue() < entry.getValue()){
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }

        for(int i=k-1; i>=0; i--){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
