package ArrayString;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer exists = map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (exists == null || exists < 2) {
                nums[j++] = nums[i];
            }
        }
        return j - 1;
    }

    public int removeDuplicatesImproved(int[] nums) {
        int slow = 2;
        int fast = 2;
        int length = nums.length;
        if (length <= 2) {
            return length;
        }

        while (fast < length) {
            if (nums[fast] == nums[slow - 2]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        removeDuplicatesFromSortedArrayII.removeDuplicates(new int[] {1, 1, 1, 2, 2, 3});
    }
}
