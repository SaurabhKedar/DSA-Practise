public class ToggleCase {
    static String toggleCase(String A){
        if (A.isEmpty() || A.isBlank()) return "";
        char[] arr = A.trim().toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char)(arr[i] + 32);
            }else {
                arr[i] = (char)(arr[i] - 32);
            }
        }
        return new String(arr);
    }

    static void main() {
        String A = "HelloThisIsHakunaMatata";
        System.out.println(toggleCase(A));
    }
}
