//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 11 | DSA: Hashing 3: Internal Implementation & Problems

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams1 {
    static ArrayList<ArrayList<String>> groupAnagrams(String[] A)
    {
        // Map each sorted-character key to its original strings.
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : A) {
            // Convert the string into a character array for sorting.
            char[] chars = str.toCharArray();

            // Sorting makes anagrams share the same group key.
            Arrays.sort(chars);
            String key = new String(chars);

            // Create a group the first time this key is encountered.
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            // Keep the original string in the result group.
            map.get(key).add(str);
        }

        // Collect the map's groups into the required 2D ArrayList.
        return new ArrayList<ArrayList<String>>(map.values());
    }
    static void main() {
        String[] A = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(A));
    }
}
