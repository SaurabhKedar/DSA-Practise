import java.util.Arrays;

public class SearchForRange {
    static int[] searchRange(final int[] A, int B) {
        int first = findFirst(A, B);
        int last = findLast(A, B);
        return new int[]{first, last};
    }

    static int findFirst(final int[] A, int B){
        int n = A.length;
        int ans = -1;
        int left = 0;
        int right = n -1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if (A[mid] == B){
                ans = mid;
                right = mid - 1;
            }
            else  if (A[mid] < B){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    static int findLast(final int[] A, int B){
        int n = A.length;
        int ans = -1;
        int left = 0;
        int right = n -1;
        while (left <= right){
            int mid = left + ((right - left) / 2);
            if (A[mid] == B){
                ans = mid;
                left = mid  + 1;
            }
            else if (A[mid] < B){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
    static void main() {
        int[]  A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        System.out.println(Arrays.toString(searchRange(A, B)));
    }
}
