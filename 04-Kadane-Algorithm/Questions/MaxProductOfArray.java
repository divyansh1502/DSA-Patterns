public class MaxProductOfArray {
    public static void main(String[] args) {
        int[] arr = {-6, 2, 0, 4, 1, 3, 4, -3};
        System.out.println(maxProduct(arr));
    }
    static int maxProduct(int[] arr) {
        int pre = 1;
        int suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre = pre * arr[i];
            suff = suff * arr[arr.length - i - 1];

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}