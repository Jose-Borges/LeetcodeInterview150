package HashMap;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int desiredKey = target - nums[i];
            int idx = map.getOrDefault(desiredKey, -1);
            if (idx != -1 && idx != i) {
                return new int[] {i, idx};
            }
        }
        return new int[] {};
    }
}
