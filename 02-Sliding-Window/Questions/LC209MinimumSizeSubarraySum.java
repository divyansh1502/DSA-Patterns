
public class LC209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2,3,2,2,4,3};
        System.out.println(minSubArrayLen(arr, 0));
    }
    static int minSubArrayLen(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while(sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
