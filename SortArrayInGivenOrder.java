//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 11 | DSA: Hashing 3: Internal Implementation & Problems

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortArrayInGivenOrder {
    static ArrayList<Integer> solve(
            ArrayList<Integer> A,
            ArrayList<Integer> B
    ) {

        // Store the frequency of every value in A.
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : A) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Emit values in B's order, preserving each value's frequency.
        for (int num : B) {
            if (frequency.containsKey(num)) {
                int count = frequency.get(num);

                // Add every occurrence before removing this processed key.
                for (int i = 0; i < count; i++) {
                    result.add(num);
                }
                frequency.remove(num);
            }
        }

        // Only values absent from B remain in the frequency map.
        ArrayList<Integer> remaining = new ArrayList<>(frequency.keySet());
        Collections.sort(remaining);

        // Append remaining values in ascending order, including duplicates.
        for (int num : remaining) {
            int count = frequency.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
        }

        return result;
    }
    static void main() {

    }
}
