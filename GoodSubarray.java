class GoodSubarray {
    static int goodSubarraysCount(int[] A, int B){
        int n = A.length;
        int[] pf = new int[n];
        pf[0] = A[0];
        for (int i = 1; i < n; i++){
            pf[i] = pf[i-1] + A[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int sum = 0;
                if (i == 0){
                    sum = pf[j];
                }else {
                    sum = pf[j] - pf[i-1];
                }

                int len = j - i + 1;

                if (len % 2 == 0 && sum < B){
                    ans++;
                }

                if (len % 2 == 1 && sum > B){
                    ans++;
                }
            }
        }
        return ans;
    }
    static void main() {
        int[] A = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int B = 65;
        System.out.println(goodSubarraysCount(A, B));
    }
}
