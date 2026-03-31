package ArrayString;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        Integer currElem = null, majorElem = null;
        for (int num : nums) {
            if (currElem == null || currElem != num) {
                if (count > length / 2) {
                    majorElem = currElem;
                }
                currElem = num;
                count = 1;
            } else {
                count++;
            }
        }
        if (majorElem == null || count > length / 2) {
            majorElem = currElem;
        }
        return majorElem;
    }
}
