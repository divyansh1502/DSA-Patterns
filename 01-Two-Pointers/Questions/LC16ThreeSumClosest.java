import java.util.Arrays;

public class LC16ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.print(threeSumClosest(arr, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if(diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if(target == sum) {
                    return sum;
                }

                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            
        }
        return result;
    }
}
