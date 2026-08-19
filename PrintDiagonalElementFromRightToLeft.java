public class PrintDiagonalElementFromRightToLeft {
    static void main() {
        int[][] mat = {
                {1, 2, 1, 3, 4},
                {4, 5, 6, 6, 7},
                {8, 9, 8, 9, 7},
                {6, 4, 5, 6, 1}
        };

        int i = 0;
        for(int j = 0 ; j < mat[0].length; j++){
            int start = i;
            int end = j;
            while (start < mat.length && end >= 0){
                System.out.print(mat[start][end] + " ");
                start++;
                end--;
            }
            System.out.println();
        }

        int j = mat[0].length - 1;
        for (int r=1; r < mat.length; r++){
            int start = r;
            int end = j;
            while (start < mat.length && end >= 0){
                System.out.print(mat[start][end] + " ");
                start++;
                end--;
            }
            System.out.println();

        }
    }
}
