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
       // String[] test = new String[]{"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        String[] test2 = new String[]{"a","a","b"};
        System.out.println(Arrays.toString(method(test2, 1)));
        //System.out.println(Arrays.toString(method(test, 5)));
    }


    public static String[] method(String[] combo, int k){
        // Write your solution here
        String[] result = new String[0];
        if(combo.length == 0){
            return result;
        }



        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for(String str : combo){
            Integer temp = map.get(str);
            if(temp == null){
                count++;
                map.put(str, 1);
            }else{
                map.put(str, temp+1);
            }
        }

        if(k > count){
            k = count;
        }
        result = new String[k];


        PriorityQueue<Map.Entry<String, Integer>> minheap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if(e1.getValue() == e2.getValue()){
                    return 0;
                }
                return e1.getValue() < e2.getValue() ? -1 : 1;
            }
        });


        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(minheap.size() < k){
                minheap.offer(entry);
            }else{
                if(entry.getValue() > minheap.peek().getValue()){
                    minheap.poll();
                    minheap.offer(entry);
                }
            }

        }

        for(int i=k-1; i>=0; i--){
            result[i] = minheap.poll().getKey();
        }
        return result;
    }
}
