public class DecompressString {

    public static void main(String[] args) {

        String test = "ab3ccd2ef3";
        System.out.println(decompress(test));
    }


    public static String decompress(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return input;
        }

        int count;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){

            char temp = input.charAt(i);   //这里有坑，因为要考虑下一位，如果不把字符取出，考虑下一步对数字取值（++i）字符就会丢失，刻舟求剑
            if(Character.isLetter(temp)){
                if(i+1 ==input.length() || Character.isLetter(input.charAt(i+1))){
                    sb.append(temp);
                }else{
                    count = input.charAt(++i) - '0';
                    while(count != 0){
                        sb.append(temp);
                        count--;
                    }
                }
            }
        }

        return new String(sb);
    }
}
