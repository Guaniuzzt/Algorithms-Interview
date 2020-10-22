public class CompressStringII {


    public static void main(String[] args) {
        String test = "aaabbbccdeef";
        System.out.print(compress(test));
    }

    public static String compress(String input) {
        // Write your solution here

        if(input == null || input.length() <= 0){
            return input;
        }
        int pre = 0;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        for(int i=1; i<input.length(); i++){
            if(input.charAt(i) != input.charAt(pre)){
                sb.append(count);
                sb.append(input.charAt(i));
                count = 1;
                pre = i;
            }else{
                count++;
            }
        }
        sb.append(count);    //要注意别忘了最后一个char需要count
        return new String(sb);
    }
}
