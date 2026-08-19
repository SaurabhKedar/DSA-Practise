import java.util.ArrayList;

public class LeadersInAnArray {
    static ArrayList<Integer> leadersInArray(int[] A){
        int n = A.length;
        int max_from_right = A[n-1];
        ArrayList<Integer> leaders = new ArrayList();
        leaders.add(max_from_right);

        for (int i = n-2; i >= 0; i--){
            int temp = A[i];
            if (temp >= max_from_right){
                leaders.add(0, temp);
                max_from_right = temp;
            }
        }

        return leaders;
    }
    static void main() {
        int[] A = {16, 17, 4, 3, 5, 2};
        System.out.println(leadersInArray(A));
    }
}
