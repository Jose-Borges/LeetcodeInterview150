package ArrayString;

import java.util.ArrayList;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] productArray = new int[length];
        int total = 1;
        boolean zeroFlag = false;
        for (int num : nums) {
            if (!zeroFlag && num == 0) {
                zeroFlag = true;
            } else {
                total *= num;
            }
        }
        for (int i = 0; i < length; i++) {
            if (zeroFlag && nums[i] != 0) {
                productArray[i] = 0;
            } else {
                productArray[i] = nums[i] != 0 ? total / nums[i] : total;
            }
        }
        return productArray;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(new int[] {-1,1,0,-3,3});
    }
}
