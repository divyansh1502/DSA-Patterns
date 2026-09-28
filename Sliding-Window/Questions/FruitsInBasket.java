import java.util.*;

public class FruitsInBasket {
    public static void main(String[] args) {
        int[] fruits = {1, 1, 1, 2, 2, 4, 4, 4, 4, 6, 3, 2};
        System.out.println(totalFruits(fruits));
    }
    static int totalFruits(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
