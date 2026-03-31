package ArrayString;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int rotation = k % length;
        if (rotation == 0) return;
        int[] lastNums = Arrays.copyOfRange(nums, length - rotation, length);

        for (int i = length - 1; i >= rotation; i--) {
            nums[i] = nums[i - rotation];
        }

        System.arraycopy(lastNums, 0, nums, 0, rotation);
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
