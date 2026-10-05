public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(happyNumber(19));
    }
    static boolean happyNumber(int n) {
        int slow = n;
        int fast = n;
        do { 
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);
        return slow == 1;
    }   
    static int square(int n) {
        int sum = 0;
        while(n > 0) {
            int ld = n % 10;
            sum += ld * ld;
            n /= 10;
        }
        return sum;
    }
}
