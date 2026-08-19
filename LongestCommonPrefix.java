import java.util.Arrays;

public class LongestCommonPrefix {
    static String longestCommonPrefix(String[] A){
        int n = A.length;
        Arrays.sort(A);
        String first = A[0];
        String last = A[n-1];
        int minLen = Math.min(first.length(), last.length());

        int i = 0;
        while (i < minLen && first.charAt(i) == last.charAt(i)){
            i++;
        }

        return last.substring(0, i);
    }

    static void main() {
        String[] A = {"abcdefgh", "abcefghijk", "abcefgh"};
        System.out.println(longestCommonPrefix(A));
    }
}
