//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 5 | DSA: Lab Session on Backtracking

public class ShortestPathInBinaryMazeWithHurdles {
    static int FindShortestPath(int[][] A, int B, int C, int D, int E){
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = explorePaths(A, visited, B, C, D, E);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    static int explorePaths(
            int[][] A,
            boolean[][] visited,
            int currRow,
            int currCol,
            int destRow,
            int destCol
    ){
        if (currRow == destRow && currCol == destCol){
            return 0;
        }

        int m = A.length, n = A[0].length;

        visited[currRow][currCol] = true;

        int[] rows = {-1, 0, 1, 0}, cols = {0, 1, 0, -1};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++){
            int newRow = currRow + rows[i];
            int newCol = currCol + cols[i];
            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && visited[newRow][newCol] == false && A[newRow][newCol] == 1){
                int dist = explorePaths(A, visited, newRow, newCol, destRow, destCol);
                if (dist != Integer.MAX_VALUE){
                    min = Math.min(min, dist  + 1);
                }
            }
        }

        visited[currRow][currCol] = false;

        return min;
    }
    static void main() {
        System.out.println();
    }
}
