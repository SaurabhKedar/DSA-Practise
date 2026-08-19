import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    static int lengthOfLongestSubstring(String A) {
        int n = A.length();
        int start = 0;
        int end = 0;
        int ans = 0;

        HashSet<Character> hs = new HashSet<>();
        while (end < n){
            char e = A.charAt(end);
            char s = A.charAt(start);
            if (!hs.contains(e)){
                hs.add(e);
                end++;
            }else {
                hs.remove(s);
                start++;
            }
            ans = Math.max(ans, hs.size());
        }
        return ans;
    }
    static void main() {
        System.out.println(lengthOfLongestSubstring("abcdaccbabde"));
    }
}
