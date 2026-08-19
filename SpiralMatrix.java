import java.util.Arrays;

public class SpiralMatrix {
    static int[] printSpiralMatrix(int[][] A){
            int rows = A.length;
            int cols = A[0].length;
            int[] result = new int[rows * cols];
            int idx = 0;

            int top = 0, bottom = rows - 1;
            int left = 0, right = cols - 1;

            while (top <= bottom && left <= right){

                for (int i = left; i <= right; i++){
                    result[idx++] = A[top][i];
                }
                top++;

                for (int i = top; i <= bottom; i++) {
                    result[idx++] = A[i][right];
                }
                right--;

                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        result[idx++] = A[bottom][i];
                    }
                    bottom--;
                }

                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result[idx++] = A[i][left];
                    }
                    left++;
                }
            }

            return result;
    }
    static void main() {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(printSpiralMatrix(A)));
    }
}
