
public class MaxSumArray {
    public static void main(String[] args) {
        int[] arr = {4, -5, 6, -1, -4, 3, 5, -2, -4};
        System.out.println(minSum(arr));
    }
    static int minSum(int[] nums) {
        int sum = 0;
        int max  = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            max = Math.max(max, sum);
            if(sum < 0) {
                sum = 0;
            }
  
        }
        return max;
    }
}
