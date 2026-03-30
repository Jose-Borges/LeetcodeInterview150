package ArrayString;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        m--;
        n--;
        int i = nums1.length - 1;
        while (i >= 0) {
            if (m < 0) {
                nums1[i--] = nums2[n--];
            } else if (n < 0) {
                nums1[i--] = nums1[m--];
            } else if (nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }
    }
}
