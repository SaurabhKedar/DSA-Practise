import java.util.Arrays;

public class PartitionIndex {
    static int partition(int[] arr) {
        int n = arr.length;
        int P = arr[n - 1];
        int l = 0;
        int r = n - 2;

        while (l <= r) {
            if (arr[l] < P) {
                l++;
            } else if (arr[r] > P) {
                r--;
            } else {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        // Correct pivot placement
        int temp = arr[n - 1];
        arr[n - 1] = arr[l];
        arr[l] = temp;

        return l; // correct partition index
    }

    static void main() {
        int[] A = {6, 2, 0, 4, 5};
        System.out.println(partition(A));
    }
}
