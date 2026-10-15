//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

public class ContainerWithMostWater {
    static int maxArea(int[] A){
        int left = 0;
        int right = A.length - 1;
        int maxArea = 0;

        // Continue while two different lines remain.
        while (left < right) {
            // Water height is limited by the shorter line.
            int height = Math.min(A[left], A[right]);

            // Width is the distance between the lines.
            int width = right - left;

            // Calculate this container's area.
            int area = height * width;

            // Update the best area found so far.
            maxArea = Math.max(maxArea, area);

            // Move the pointer at the shorter boundary.
            if (A[left] < A[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    static void main() {
        int[] A = {4, 2, 10, 6, 8, 2, 6, 2};
        System.out.println(maxArea(A));
    }
}
