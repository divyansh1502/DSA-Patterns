

public class Main {
    public static void main(String[] args) {
        System.out.println(slidingWindow("AABAAAABBABABBA", 2));
    }
    static int slidingWindow(String s, int k) {
        int[] freq = new int[26];
        int ans = 0;
        int maxFreq = 0;
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;
            int replacements = windowSize - maxFreq;

            while(replacements > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                windowSize = right - left + 1;
                replacements = windowSize - maxFreq;
            }
            ans = Math.max(ans, windowSize);
            right++;
        }
        return ans;
    
    }
}
    
