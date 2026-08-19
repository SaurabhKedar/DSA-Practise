class ReverseTheString {
    static String reverseString(String A){
        if (A.isBlank() || A.isEmpty()) return "";
        String[] arr = A.trim().split(" ");
        int n = arr.length;
        int i = 0;
        int e = n - 1;
        while (i < e){
            String temp = arr[i];
            arr[i] = arr[e];
            arr[e] = temp;
            i++;
            e--;
        }

        String ans = "";
        for (int x = 0; x < n; x++){
            ans = ans.concat(arr[x]);
            if (x != n - 1){
                ans = ans.concat(" ");
            }
        }

        return ans;
    }
    static void main() {
        String s = " India is my country ";
        System.out.println(reverseString(s));
    }
}
