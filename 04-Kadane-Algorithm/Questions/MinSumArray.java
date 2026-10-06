
public class MinSumArray {
    public static void main(String[] args) {
        int[] arr = {4, -5, 6, -2, -3, -4, 6, -7};
        System.out.println(minSum(arr));
    }
    static int minSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            min = Math.min(min, sum);
            if(sum > 0) {
                sum = 0;
            }
        }
        return min;
    }
}
