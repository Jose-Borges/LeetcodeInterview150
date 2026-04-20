package HashMap;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        HashMap<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (!valToIdx.containsKey(currNum)) {
                valToIdx.put(currNum, i);
            } else {
                if (valToIdx.get(currNum) + k >= i) {
                    return true;
                } else {
                    valToIdx.put(currNum, i);
                }
            }
        }
        return false;
    }
}
