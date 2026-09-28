
import java.util.*;

public class LongestSubStringKDistinct {
    public static void main(String[] args) {
        System.out.println(longestSubString("aaabbcccddee", 2));
    }
    static int longestSubString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()) {
            char chr = s.charAt(right);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
            while(map.size() > k) {
                char chl = s.charAt(left);
                map.put(chl, map.getOrDefault(chl, 0) - 1);
                if(map.get(chl) == 0) {
                    map.remove(chl);
                }
                left++;
            }
            if(map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
                
            right++;
        }
        return maxLen;
    }
}