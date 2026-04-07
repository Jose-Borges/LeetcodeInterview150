package ArrayString;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int aux = 0;
        for(int num: nums) {
            if (aux < 0) {
                return false;
            }
            if (aux < num) {
                aux = num;
            }
            aux--;
        }
        return true;
    }
}
