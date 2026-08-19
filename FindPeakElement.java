public class FindPeakElement {
    static int findLocalMaxima(int[] A) {
        int low = 0;
        int high = A.length - 1;

        // We use low < high (not <=) because we are narrowing down to one element
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Compare mid with next element to understand the slope
            // If current element is smaller than next → increasing slope
            if (A[mid] < A[mid + 1]) {
                // Peak must exist on the right side
                // because we are going upwards
                low = mid + 1;
            } else {
                // We are on decreasing slope OR at peak
                // So peak lies on left side including mid
                high = mid;
            }
        }

        // At the end, low == high → pointing to a peak element
        return A[low];
    }
    static int findLocalMinima(int[] A) {
        int low = 0;
        int high = A.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than next element,
            // we are on a downward slope → minima is on the right side
            if (A[mid] > A[mid + 1]) {
                low = mid + 1;
            }
            // Else we are on upward slope or flat,
            // minima lies on left side including mid
            else {
                high = mid;
            }
        }

        // At the end, low == high → pointing to local minima
        return A[low];
    }
    static void main() {
        int[] A = {5, 17, 100, 11};
        System.out.println(findLocalMaxima(A));
        System.out.println(findLocalMinima(A));
    }
}
