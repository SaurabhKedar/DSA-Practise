public class SearchElementSortedMatrix {
    static int solve(int[][] A, int B){
        int rows = A.length;
        int cols = A[0].length;
        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0){
            if (A[i][j] == B){
                return B;
            } else if (A[i][j] < B) {
                i++;
            }else {
                j--;
            }
        }

        return -1;
    }
    static void main() {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solve(A, 2));
    }
}
