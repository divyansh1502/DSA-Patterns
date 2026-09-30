
import java.util.*;

public class LC259ThreeSumSmaller {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 2};
        System.out.println(threeSumSmaller(arr, 2));
    }
    static List<List<Integer>> threeSumSmaller(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum < target) {
                    for (int j = left + 1; j <= right; j++) {
                        list.add(Arrays.asList(arr[i], arr[left], arr[j]));
                    }
                    left++;
                } else right--;
            }
                
        }
        return list;
    }
    
}

