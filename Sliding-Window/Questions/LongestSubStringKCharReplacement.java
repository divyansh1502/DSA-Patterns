public class LongestSubStringKCharReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBBCCBBBD", 2));
    }
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int ans = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
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
        }
        return ans;
    }
}
