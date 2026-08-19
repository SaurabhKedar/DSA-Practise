public class CheckAnagram {
    static boolean isAnagram(String A, String B){
        int a = A.length();
        int b = B.length();

        if (a != b) return false;

        int[] freq = new int[26];

        for (int i = 0; i < a; i++){
            freq[A.charAt(i) - 'a']++;
        }

        for (int j = 0; j < b; j++){
            freq[B.charAt(j) - 'a']--;
        }

        for (int x : freq){
            if (x != 0){
                return false;
            }
        }

        return true;
    }

    static void main() {
        String A = "abce";
        String B = "bac";
        System.out.println(isAnagram(A, B));
        System.out.println((int)'a');
        System.out.println((int)'A');


    }
}
