import java.util.Random;

public class Random1000UsingRandom5 {

    public int random1000() {
        // Write your solution here.
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while(true){

            int temp = 0;
            temp = RandomFive.random5() * 5 + RandomFive.random5(); // 0-24
            temp = temp * 5 + RandomFive.random5(); // 0-124
            temp = temp * 5 + RandomFive.random5(); // 0-624
            temp = temp * 5 + RandomFive.random5(); // 0-3124

            if(temp < 3000){
                return temp % 1000;
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
