public class LongestPalindromeSubstring {
    static String longestPalindrome(String A){
        int n = A.length();
        String ans = "";
        int maxLen = 0;

        for (int mid = 0; mid < n; mid++){
            //This block is for if longest palindrome is odd length
            int left = mid;
            int right = mid;
            while (left >= 0 && right < n){
                if (A.charAt(left) != A.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len > maxLen){
                maxLen = len;
                ans = A.substring(left+1, right);
            }

            //This block is for if longest palindrome is even length
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < n){
                if (A.charAt(left) != A.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            len = right - left - 1;
            if (len > maxLen){
                maxLen = len;
                ans = A.substring(left+1, right);
            }
        }
        return ans;
    }

    static void main() {
        String A = "aaaabaaaabba";
        System.out.println(longestPalindrome(A));
    }
}
