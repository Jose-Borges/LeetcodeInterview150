package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        boolean isSequence = false;
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (sb.isEmpty()) {
                sb.append(nums[i]);
            } else {
                if (nums[i - 1] + 1 != nums[i]) {
                    if (isSequence) {
                        sb.append("->").append(nums[i - 1]);
                    }
                    list.add(sb.toString());
                    sb.setLength(0);
                    sb.append(nums[i]);
                    isSequence = false;
                }
                else {
                    isSequence = true;
                }
            }
        }
        if (isSequence) {
            sb.append("->").append(nums[nums.length - 1]);
        }
        list.add(sb.toString());
        return list;
    }
}
