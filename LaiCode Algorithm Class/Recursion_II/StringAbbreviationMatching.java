public class StringAbbreviationMatching {

    /*
    傻叼题目，这题都用分类到recursion不是和自己过不去吗
    遍历盘它,
    Time: O(n)
    Space:O(1)
     */
    public static void main(String[] args) {
        String input = "apple";
        String pattern = "2p1";

        System.out.print(match(input, pattern));

    }

    public static boolean match(String input, String pattern) {
        // Write your solution here

        if(input.length() == 0 && pattern.length() == 0){
            return true;
        }else if(input.length() == 0 || pattern.length() == 0){
            return false;
        }

        int inputindex = 0;
        int patternindex = 0;

        while(inputindex < input.length() && patternindex < pattern.length()){

            if(Character.isLetter(input.charAt(inputindex)) && Character.isLetter(pattern.charAt(patternindex))){
                if(input.charAt(inputindex) == pattern.charAt(patternindex)){
                    inputindex++;
                    patternindex++;
                }else{
                    return false;
                }
            }else{
                int num = 0;
                while(patternindex < pattern.length() && Character.isDigit(pattern.charAt(patternindex))){
                    num = num * 10 + pattern.charAt(patternindex) - '0';
                    patternindex++;
                }
                inputindex += num;
                if(patternindex == pattern.length() && inputindex  == input.length()){
                    return true;
                }else if(inputindex >= input.length()){
                    return false;
                }

            }
        }
        if(inputindex != input.length() || patternindex != pattern.length())
            return false;
        return true;
    }
}
