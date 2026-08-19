import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
    public int[][] towerOfHanoi(int A) {
        List<int[]> result = new ArrayList<>();

        solve(A, 1, 3, 2, result);

        int[][] ans = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void solve(int disk, int start, int end, int helper, List<int[]> result) {
        if (disk == 0) return;

        // Step 1: Move n-1 disks to helper
        solve(disk - 1, start, helper, end, result);

        // Step 2: Move current disk
        result.add(new int[]{disk, start, end});

        // Step 3: Move n-1 disks to destination
        solve(disk - 1, helper, end, start, result);
    }
    static void main() {

    }
}
