public class ReserveWordsInASentence {

    //I love Leetcode => Leetcode love I
    public static void main(String[] args) {
        String test = "I love Leetcode";
        System.out.print(reverseWords(test));
    }


    public static String reverseWords(String input) {
        // Write your solution here

        if(input == null || input.length() <=1){
            return input;
        }

        char[] array = input.toCharArray();
        int i=0;
        int j = array.length -1;

        swap(array, i, j);  //反转一遍后再把每个单词反转

        int slow = 0;


        for(int k=0; k<array.length; k++){
            if(array[k] == ' '){
                swap(array, slow, k-1);
                slow = k+1;
            }else if(k == array.length-1){
                swap(array, slow, k);
            }
        }

        return new String(array);
    }


    public static char[] swap(char[] array, int i, int j){
        while(i < j){
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }

        return array;
    }

}
