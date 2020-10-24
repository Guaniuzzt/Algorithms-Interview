

public class RightShiftByNCharacter {


    public static void main(String[] args) {

        String test = "abcdefg";
        System.out.println(method(test, 9));

    }


    public static String method(String input, int k){

        if(input == null || input.length() == 0)
            return input;

        k = k % input.length();
        char[] array = input.toCharArray();
        swap(array, 0, array.length - 1);
        swap(array, 0, k-1);
        swap(array, k, array.length - 1);

        return new String(array);





    }

    public static void swap(char[] array, int i, int j){

        while(i < j){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }



}
