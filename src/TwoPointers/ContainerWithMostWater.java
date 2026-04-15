package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int maxHeight = Math.min(height[i], height[j]);
            int currArea = maxHeight * (j - i);
            maxArea = Math.max(maxArea, currArea);

            if (height[i] < height [j]) i++;
            else j++;
        }
        return maxArea;
    }
}
