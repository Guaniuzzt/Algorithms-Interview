public class ReserveString {

    public static void main(String[] args) {
        String test = "abc";
        System.out.println(method(test));
    }

    public static String method(String input){
        if(input == null || input.length() == 0)
            return input;
        int left = 0;
        int right = input.length() - 1;
        char[] array = input.toCharArray();
        while(left <= right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return new String(array);
    }

}
