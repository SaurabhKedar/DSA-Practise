import java.util.Arrays;

public class RepeatNumber {
    static int repeatNumberNby3(int[] A){
        int candidate1 = 0, count1 = 0;
        int candidate2 = 1, count2 = 0;
        int n = A.length;

        for (int i = 0; i < n; i++){
            int num = A[i];
            if (num == candidate1){
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int x : A){
            if (x == candidate1){
                count1++;
            }
            if (x == candidate2){
                count2++;
            }
        }

        if (count1 > n/3) return  candidate1;
        if (count2 > n/3) return  candidate2;

        return -1;
    }

    static void main() {
        int[] arr = {1, 2, 3, 1, 1, 2, 2, 2, 2};
        System.out.println(repeatNumberNby3(arr));
    }
}
