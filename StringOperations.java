public class StringOperations {
    static String solve(String A){
        A = A.concat(A);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < A.length(); i++){
            char c = A.charAt(i);
            boolean isVowel = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
            boolean isUppercase = c >= 'A' && c <= 'Z';
            if (!isVowel && !isUppercase){
                ans.append(c);
            }
            if (isVowel){
                ans.append('#');
            }
        }
        return ans.toString();
    }

    static void main() {
        String A = "India";
        System.out.println(solve(A));
    }
}
