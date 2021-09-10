import java.util.List;

public class Percentile {


    /*
    Given a list of integers representing the lengths of urls,
    find the 95 percentile of all lengths
    (95% of the urls have lengths <= returned length).
     */

    public int percentile95(List<Integer> lengths) {
        // Write your solution here.


        int[] count = new int[4097];
        for(int len : lengths){
            count[len]++;
        }

        int sum = 0;
        int index = 0;

        while(sum < 0.95 * lengths.size()){
            sum += count[index++];
        }
        // not included exceed part, so return index-1
        return index-1;
    }

}
