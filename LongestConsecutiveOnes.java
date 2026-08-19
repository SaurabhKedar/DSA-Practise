public class LongestConsecutiveOnes {
    static int solve(String A){
        int n = A.length();
        int ans = 0;

        int totalOnes = 0;
        int totalZeros = 0;

        for (int i = 0; i < n; i++){
            char c = A.charAt(i);
            if (c == '1') totalOnes++;
            if (c == '0') totalZeros++;
        }

        if (totalOnes == n) return totalOnes;
        if (totalZeros == n) return 0;

        for (int mid = 0; mid < n; mid++){
            if (A.charAt(mid) == '0'){
                int left = mid - 1;
                int right = mid + 1;
                int totalOnesOnLeft = 0;
                int totalOnesOnRight = 0;

                while (left >= 0 && A.charAt(left) == '1'){
                    totalOnesOnLeft++;
                    left--;
                }

                while (right < n && A.charAt(right) == '1'){
                    totalOnesOnRight++;
                    right++;
                }

                //This is approach is correct if the swap is there
                int count = totalOnesOnLeft + totalOnesOnRight;

                if (count < totalOnes){
                    ans = Math.max(ans, count + 1);
                }else {
                    ans = Math.max(ans, count);
                }

                //This is approach is correct if the swap is not there
//                int len = right - left - 1;
//                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
    static void main() {
            String A = "111000111011101";
        System.out.println(solve(A));
    }
}
