import java.util.Arrays;

public class SetZeroInRowAndColumnInMatrix {
    static int[][] setZerosInMatrix(int[][] A){
        int rows = A.length;
        int cols = A[0].length;

        //Traverse through rowwise and set row elements as -1 except 0
        for (int i = 0; i < rows; i++){
            boolean flag = false;
            for (int j = 0; j < cols; j++){
                if (A[i][j] == 0){
                    flag = true;
                }
            }
            if (flag){
                for (int j = 0; j < cols; j++){
                    if (A[i][j] != 0){
                        A[i][j] = -1;
                    }
                }
            }
        }

        //Traverse through columnwise and set column elements as -1 except 0
        for (int j = 0; j < cols; j++){
            boolean flag = false;
            for (int i = 0; i < rows; i++){
                if (A[i][j] == 0){
                    flag = true;
                }
            }
            if (flag){
                for (int i = 0; i < rows; i++){
                    if (A[i][j] != 0){
                        A[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (A[i][j] == -1){
                    A[i][j] = 0;
                }
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        return A;
    }
    static void main() {
        int[][] A = {
                {1, 2, 1, 3, 4},
                {4, 5, 0, 6, 7},
                {8, 9, 8, 0, 7},
                {6, 5, 5, 6, 1}
        };
        System.out.println(setZerosInMatrix(A));
    }
}
