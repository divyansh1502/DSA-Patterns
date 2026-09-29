import java.util.*;

public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubString("abcadefb"));
    }
    static int longestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < s.length()) {
            char chr = s.charAt(right);
            while(set.contains(chr)) {
                char chl = s.charAt(left);
                set.remove(chl);
                left++;
            }
            set.add(chr);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }
}