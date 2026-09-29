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
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }
}