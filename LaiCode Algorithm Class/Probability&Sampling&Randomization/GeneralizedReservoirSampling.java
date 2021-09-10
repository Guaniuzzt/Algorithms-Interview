import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneralizedReservoirSampling {

    private final int k;
    private List<Integer> result;
    private int count;

    public GeneralizedReservoirSampling(int k) {
        // Complete the constructor if necessary.
        this.k = k;
        this.count = 0;
        result = new ArrayList<Integer>();
    }

    public void read(int value) {
        // Write your implementation here.
        Random rand = new Random();
        count++;
        if(count <= k){
            result.add(value);
        }else{
            int index = rand.nextInt(count);
            if(index < k){
                result.set(index, value);
            }
        }
    }

    public List<Integer> sample() {
        // Write your implementation here.
        return result;
    }
}
