public class MissingNumberI {


    /*
    Given an integer array of size N - 1,
    containing all the numbers from 1 to N except one,
    find the missing number.


    Using ^;
    Time: O(n)
    Space: O(1)
     */



    public static void main(String[] args) {

        int[] test = new int[]{1,3,4};
        System.out.println(method(test));

    }


    public static int method(int[] array){

        if(array.length == 0)
            return 1;

        int temp = array[0];
        for(int i=1; i<array.length; i++){
            temp = temp ^ array[i];
        }

        for(int i=1; i<=array.length + 1; i++){
            temp = temp ^ i;
        }

        return temp;
    }


}
