import java.util.Arrays;

public class ElementsRemoval {
    static int costOfRemovalElements(int[] A){
        Arrays.sort(A);
        int n = A.length;
        if (n == 1) return A[0];

        int sum = 0;
        for (int x : A){
            sum += x;
        }

        int cost = 0;
        for (int i = n-1; i >= 0; i--){
            cost += sum;
            sum -= A[i];
        }

        return cost;
    }

    static void main() {
        int[] arr = {2, 1};
        System.out.println(costOfRemovalElements(arr));
    }
}
