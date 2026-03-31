package ArrayString;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        Integer currElem = null, majorElem = null;
        for (int i = 0; i < length; i++) {
            if (currElem == null || currElem != nums[i]) {
                if (count > length / 2) {
                    majorElem = currElem;
                }
                currElem = nums[i];
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

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2});
    }
}
