import java.util.HashSet;

public class ColorfulNumber {
    static boolean isColorfulNumber(int A){
        String s = String.valueOf(A);
        int n = s.length();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j= i; j < n; j++){
                int digit = s.charAt(j) - '0';
                product *= digit;

                if (set.contains(product)){
                    return false;
                }

                set.add(product);
            }
        }
        return true;
    }

    static void main() {
        System.out.println(isColorfulNumber(63));
//        System.out.println((int)'9');
//        System.out.println((int)'0');
    }
}
