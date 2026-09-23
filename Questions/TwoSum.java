
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 1, 3, 7, 9, 11};
        int target = 2;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        
    }
    static int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            if(arr[i] + arr[j] == target) {
                return new int[]{i, j};
            } else if(arr[i] + arr[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
// Two pointer approach 
// array is sorted