import java.util.Arrays;

public class LC88MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 7, 9, 15, 24, 25};
        int[] arr2 = {1, 12, 14, 19, 22, 27, 31, 36, 67, 94, 102};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }
    static int[] merge(int[] first, int[] second) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] mix = new int[first.length + second.length];

        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while(i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
