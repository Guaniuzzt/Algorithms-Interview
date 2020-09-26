public class AToThePowerOfB {


    /*
    8 basic data type
    long 64 bit :-2 ^ 63 ~ 2 ^ 63 -1
    int 32 bit : -2 ^ 31 ~ 2 ^ 31 -1 -2147483648 ~2147483647
    short 16bit : -2 ^15 ~ 2 ^ 15 - 1
    byte  8bit: -2 ^ 7  ~ 2 ^ 7 - 1

    boolean
    char 16bit

    float 32bit
    double 64bit

    */

    /*
    Time: O(logb)
    Space: O(logb)
    */

    public static void main(String[] args) {

        int a = 3;
        int b = 2;
        System.out.println(power(a, b));

    }


    public static long power(int a, int b){

        if(b == 0)
            return 1;

        if(a == 0)
            return 0;

        long temp = power(a, b/2);
        if(b % 2 ==1)
            return a * temp * temp;
        else
            return temp * temp;
    }
}
