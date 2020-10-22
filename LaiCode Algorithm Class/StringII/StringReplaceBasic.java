public class StringReplaceBasic {

    public static void main(String[] args) {

        String input = "abcdeab";
        String target = "ab";
        String replacement = "ba";
        System.out.println(method(input, target, replacement));

    }


    public static String method(String input, String target, String replacement){
        if(input == null || input.length() == 0){
            return input;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != target.charAt(0)){
                sb.append(input.charAt(i));
            }else{
                int temp = 0;
                while(temp < target.length()){
                    if(temp + i >= input.length() || input.charAt(temp+ i) != target.charAt(temp)){
                        break;
                    }
                    temp++;
                }

                if(temp == target.length()){
                    sb.append(replacement);
                    i = i+target.length() - 1;
                }else{
                    sb.append(input.charAt(i));
                }
            }
        }
        return new String(sb);
    }
}
