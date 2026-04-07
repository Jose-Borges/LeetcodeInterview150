package ArrayString;

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        int i = 0;
        while(i < nums.length - 1 && currentEnd < nums.length) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
            i++;
        }
        return jumps;
    }
}
