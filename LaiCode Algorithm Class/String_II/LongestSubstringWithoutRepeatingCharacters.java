import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
       Time: O(n^2)
       Space: O(n)
     */
    public static void main(String[] args) {
        String test = "bcdfbd";   //return 4: bcdf
        System.out.print(longest(test));
    }

    public static int longest(String input) {
        // Write your solution here
        if(input == null || input.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int pre = 0;
        int count = 0;
        for(int i=0; i<input.length(); i++){
            if(set.add(input.charAt(i))){
                count = Math.max(count, i-pre + 1);
            }else{
                while(!set.add(input.charAt(i))){
                    set.remove(input.charAt(pre));
                    pre++;
                }
            }
        }
        return count;
    }
}
