public class LC26RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5};
        System.out.println(removeDuplicate(arr));
    }
    static int removeDuplicate(int[] arr) {
        int k = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
