public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 2, 6, 2, 2};
        System.out.println(majorityElement(arr));
    }
    static int majorityElement(int[] arr) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count == 0) {
                ans = arr[i];
                count++;
            }
            else if(ans == arr[i]) {
                count++; 
            } else {
                count--;
            }
        }
        return ans;
    }
}
    
