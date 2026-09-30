
import java.util.*;

public class LC340LongestSubStringKDistinct {
    public static void main(String[] args) {
        System.out.println(longestSubString("aaabbccdccddee", 2));
    }
    static int longestSubString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()) {     
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(map.size() > k) {         
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
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