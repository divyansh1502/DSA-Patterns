
import java.util.*;

public class LC76MinimumWindowSubString {
    public static void main(String[] args) {
        System.out.println(windowSubString("BBABAACB", "ABC"));
        
    }
    static String windowSubString(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int index1 = -1;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE; 

        // Building Frequency Map
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
            // Sliding Window
            while(right < s.length()) {

                if(map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)) > 0) {
                    count++;
                }

                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);

                while(count == t.length()) {
                    if(right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        index1 = left;
                    }
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);

                        if(map.getOrDefault(s.charAt(left), 0) > 0) {
                            count--;
                        }
                        left++;
                }
                right++;
            }
        return index1 == -1 ? "" : s.substring(index1, index1 + minLen);
    }
}
