import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {


    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0)
            return 0;

        if(s.length() == 1)
            return 1;

        Set<Character> set = new HashSet<>();
        int max = 0;
        int slow = 0;
        for(int i=0; i<s.length(); i++){

            if(!set.contains(s.charAt(i))){
                max = Math.max(max, i-slow+1);
                set.add(s.charAt(i));
            }else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                set.add(s.charAt(i));
            }
        }
        return max;
    }
}
