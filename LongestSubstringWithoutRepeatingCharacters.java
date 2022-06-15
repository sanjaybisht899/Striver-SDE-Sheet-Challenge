import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            while(!set.add(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            max=Math.max(max,set.size());
        }
        return max;
    }
    public static void main(String[] args) {
        
    }
}
