public class RemoveAdjacentRepeatedCharacters_I {

    public static void main(String[] args) {

        String test = "aaabbccccdd";
        System.out.println(deDup(test));

    }


    public static String deDup(String input) {
        // Write your solution here

        if(input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        int slow = 0;
        for(int fast=0; fast<array.length; fast++){
            if(slow == 0){
                array[slow++] = array[fast];
            }else{
                if(array[fast] != array[slow - 1]){
                    array[slow++] = array[fast];
                }
            }
        }

        return new String(array, 0, slow);
    }
}
