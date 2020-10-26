public class Longest_Palindromic_Substring {


    public static void main(String[] args) {
        String test = "abc";
        System.out.println(test.substring( 0 , 1));
        System.out.println("好蠢");
    }

    //5
    //就是个傻叼题目，只是为了告诉你string的引脚很恶心，s.substring( a, b) 返回不包含s.charAt(a+b);
    int max = 0;
    int start = 0;
    public String longestPalindrome(String s) {
        if(s == null)
            return s;
        if(s.length() < 2)  //一定要加这个core case 因为下面那个傻叼for循环只考虑(0 ~ s.length()-2), 不考虑就憨批了
            return s;
        for(int i=0; i<s.length()-1; i++){
            helper(s, i, i);   //因为palindromic可以是单数也可以是双数所以整两遍
            helper(s, i, i+1);
        }
        return s.substring(start, start + max);
    }


    public void helper(String s, int l, int r){

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(r - l - 1 > max){
            max = r - l - 1;
            start = l+1;
        }
    }
}

