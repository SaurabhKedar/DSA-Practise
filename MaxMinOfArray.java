public class MaxMinOfArray {
    static int sumOfMinMaxOfArray(int[] A){
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            if (A[i] > max){
                max = A[i];
            }
            if (A[i] < min){
                min = A[i];
            }
        }

        System.out.println("Maximum element in the array is : " + max);
        System.out.println("Minimum element in the array is : " + min);

        return max + min;
    }
    static void main() {
        int[] arr = {1, 3, 5, 23, 32, 43, 21, 34, 77, 76, 91, 19, 5668};
        System.out.println(sumOfMinMaxOfArray(arr));
    }
}
