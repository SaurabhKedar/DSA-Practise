public class SumOfAllSubmatrices {
    static int sumOfSubmatrices(int[][] A){
        int total_sum = 0;
        int rows = A.length;
        int cols = A[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int total_top_left = (i + 1) * (j + 1);
                int total_bottom_right = (rows - i) * (cols - j);
                int cont = A[i][j] * total_top_left * total_bottom_right;
                total_sum += cont;
            }
        }

        return total_sum;
    }
    static void main() {
        int[][] A = {
                {1, 1},
                {1, 1}
        };
        System.out.println(sumOfSubmatrices(A));
    }
}
