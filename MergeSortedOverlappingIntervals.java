import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedOverlappingIntervals {
    /*
    Problem Description

You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.

Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.


Problem Constraints

1 <= len(A) <= 100000.
1 <= A[i][0] <= A[i][1] <= 100000

A is sorted based on the start value (A[i][0])



Input Format

First argument is a list of intervals in 2-Dimentional Array.



Output Format

Return the sorted list of intervals after merging all the overlapping intervals.



Example Input

Input 1:

[ [1, 3], [2, 6], [8, 10], [15, 18] ]
Input 2:

[ [2, 10], [4, 9], [6, 7] ]


Example Output

Output 1:

[ [1, 6], [8, 10], [15, 18] ]
Output 2:

[ [2, 10] ]


Example Explanation

Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
Explanation 2:

Merge intervals [2, 10], [4, 9], [6, 7] as [2,10].
Since [4, 9] and [6, 7] is overlapping inside the interval [2, 10].

so, the required answer after merging is [2, 10].
     */


    static ArrayList<ArrayList<Integer>> mergeSortedOverlappingIntervals(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        int s1 = A.get(0).get(0);
        int e1 = A.get(0).get(1);

        for (int i = 1; i < A.size(); i++){
            int s2 = A.get(i).get(0);
            int e2 = A.get(i).get(1);

            if (s2 <= e1){
                s1 = Math.min(s1, s2);
                e1 = Math.max(e1, e2);
            }
            else {
                ArrayList<Integer> interval = new ArrayList();
                interval.add(s1);
                interval.add(e1);
                ans.add(interval);
                s1 = s2;
                e1 = e2;
            }
        }
        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(s1);
        interval.add(e1);
        ans.add(interval);
        return ans;
    }
    static void main() {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 3)),
                        new ArrayList<>(Arrays.asList(2, 6)),
                        new ArrayList<>(Arrays.asList(8, 10)),
                        new ArrayList<>(Arrays.asList(15, 18))
                )
        );
        System.out.println(mergeSortedOverlappingIntervals(A));
    }
}
