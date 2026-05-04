package RandomExercises.Dailys;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        //transpose
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row
        for (int i = 0; i < length; i++) {
            int left = 0, right = length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = temp;
            }
        }
    }
}
