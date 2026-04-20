package HashMap;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestSequence = 1;
        int currSequence = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                currSequence++;
            } else {
                //Ignore duplicates
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                longestSequence = Math.max(longestSequence, currSequence);
                currSequence = 1;
            }
        }
        longestSequence = Math.max(longestSequence, currSequence);
        return longestSequence;
    }
}
