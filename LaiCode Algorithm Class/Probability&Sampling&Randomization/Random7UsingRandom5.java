import java.util.Random;

public class Random7UsingRandom5 {


    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    public int random7() {
        while(true){

            int temp = 5 * RandomFive.random5() + RandomFive.random5();

            if(temp < 21){
                return temp % 7;
            }
        }

    }


    class RandomFive{

        public RandomFive(){

        }

        public static int random5(){
            Random rand = new Random();
            return rand.nextInt(5);
        }
    }

}
