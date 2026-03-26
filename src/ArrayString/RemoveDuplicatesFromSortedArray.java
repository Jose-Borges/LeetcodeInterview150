package ArrayString;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                while (j < nums.length && nums[i] == nums[j]) j++;
                if (j >= nums.length) return i;
                nums[++i] = nums[j];
            }
            else {
                i++;
                j++;
            }
        }
        return i;
    }
}
