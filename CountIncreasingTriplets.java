public class CountIncreasingTriplets {
    static int countTriplets(int[] A){
        int n = A.length;
        if(n < 3) return 0;
        int count = 0;

        for (int j = 1; j < n-1; j++){
            int leftSmaller = 0;
            int rightGreater = 0;

            for (int i = 0; i < j; i++){
                if (A[i] < A[j]){
                    leftSmaller++;
                }
            }

            for (int k = j+1; k < n; k++){
                if (A[k] > A[j]){
                    rightGreater++;
                }
            }

            count += leftSmaller * rightGreater;
        }

        return count;
    }

    static void main() {
        int[] arr = {1, 2, 4, 3, 2, 1, 2, 3};
        System.out.println(countTriplets(arr));
    }
}
