import java.util.Arrays;

public class SubarrayInGivenRange {
    static int[] subarrayInGivenRange(int[] A, int s, int e){
        int[] result = new int[e - s + 1];
        int idx = 0;
        for (int i = s; i <= e; i++){
            result[idx] = A[i];
            idx++;
        }
        return result;
    }
    static void main() {
        int[] arr = {3, 6, 2, 90, 32, 65, 21, 3, 5, 6};
        System.out.println(Arrays.toString(subarrayInGivenRange(arr, 1, 4)));
    }
}
