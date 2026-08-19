public class SubarraysWithOR {
    static int subarraysWithOR0(int[] A){
        int n = A.length;
        int lenOfCons0 = 0;
        int cntOfConsSubarrOf0 = 0;

        for (int i = 0; i < n; i++){
            if (A[i] == 0){
                lenOfCons0++;
            } else {
                cntOfConsSubarrOf0 += (lenOfCons0 * (lenOfCons0 + 1)) / 2;
                lenOfCons0 = 0;
            }
        }

        // 🔥 Important fix
        cntOfConsSubarrOf0 += (lenOfCons0 * (lenOfCons0 + 1)) / 2;

        return cntOfConsSubarrOf0;
    }
    static int subarraysWithOR1(int[] A){
        int n = A.length;
        int totalSubArrays = (n * (n + 1)) / 2;
        int ans = totalSubArrays - subarraysWithOR0(A);
        return ans;
    }
    static void main() {
        int[] A = {0, 0, 1, 1, 0};
        System.out.println(subarraysWithOR1(A));
    }
}
