import java.util.Arrays;

public class LC977SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squareSort(arr)));
    }
    static int[] squareSort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int[] result = new int[arr.length];
        for (int k = arr.length - 1; k >= 0; k--) {

            int left = arr[i] * arr[i];
                int right = arr[j] * arr[j];
                if(left < right) {
                    result[k] = right;
                    j--;
                } else {
                    result[k] = left;
                    i++;
                }
        }
        return result;
    }
}
