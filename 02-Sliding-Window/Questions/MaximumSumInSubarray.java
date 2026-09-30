
public class MaximumSumInSubarray {
    public static void main(String[] args) {
        int[] arr = {14, 25, 32, -5, 15, 34, 2, 68, -60, 16};
        System.out.println(maximumSum(arr, 3));
    }
    static int maximumSum(int[] arr, int k) {
        int sum = 0;
        int left = 0;
        int max = 0;
        for(int right = 0; right < arr.length; right++) {
            sum += arr[right];
            if(right - left + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[left];
                left++;
            }
        }
        return max;
    }
}
