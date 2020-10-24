public class DecompressStringII {

    public static void main(String[] args) {

        String test = "a1b2c3d0e1f2";   //abbccceff
        System.out.println(decompress(test));
    }



    public static String decompress(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return input;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char letter = input.charAt(i++);
            int count = input.charAt(i) - '0';
            while(count != 0){
                sb.append(letter);
                count--;
            }
        }

        return new String(sb);

    }
}
