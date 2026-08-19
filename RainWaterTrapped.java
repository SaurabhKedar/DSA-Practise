public class RainWaterTrapped {
    static  int trap(final int[] A) {
        int n = A.length;
        if (n <= 2) return 0;

        int[] maxL = new int[n];
        maxL[0] = A[0];
        for (int i = 1; i < n; i++){
            maxL[i] = Math.max(A[i], maxL[i-1]);
        }

        int[] maxR = new int[n];
        maxR[n-1] = A[n-1];
        for (int i = n-2; i >= 0; i--){
            maxR[i] = Math.max(A[i], maxR[i + 1]);
        }

        int total_water = 0;
        for (int i = 1; i < n - 1; i++){
            int water = Math.min(maxL[i], maxR[i]) - A[i];
            total_water += water;
        }

        return total_water;
    }
    static void main() {
        int[] A = {5, 4, 1, 4, 3, 2, 7};
        System.out.println(trap(A));
    }
}
