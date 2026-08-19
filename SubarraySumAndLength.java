public class SubarraySumAndLength {
    static int maxSubArraySum(int[] A, int B){
        int n = A.length;
        int i = 0;
        int j = B -1;
        int sum = 0;
        int ans = 0;
        for (int idx = i; idx < B; idx++){
            sum += A[idx];
        }
        ans = sum;
        i++;
        j++;
        while (j < n){
            sum = sum - A[i-1] + A[j];
            ans = Math.max(ans, sum);
            i++;
            j++;
        }

        return ans;
    }
    static void main(){
        int[] A = {4, 3, 2, 6, 1, 90, 21};
        int B = 3;
        System.out.println(maxSubArraySum(A, B));
    }
}
