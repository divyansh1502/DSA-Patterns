import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int count = 0; 
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(count, Arrays.asList(nums[i], nums[left], nums[right]));
                    count++;
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } 
                else if(sum > 0) {
                    right--;
                } 
                else {
                    left++;
                }
            }
        }
        return result;
    }
}
