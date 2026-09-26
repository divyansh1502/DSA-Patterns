import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4, 3};
        System.out.println(threeSum(arr));
        
    }
    static List<List<Integer>> threeSum(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    result.add(count, Arrays.asList(arr[i], arr[left], arr[right]));
                    count++;
                    left++;
                    right--;
                    while(arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while(arr[right] == arr[right + 1]) {
                        right--;
                    }
                }
                else if(sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
    
}
    
