import java.util.*;

class Solution {
    public int[][] merge(int[][] a) {
        if (a.length == 0) return new int[0][0];

        // Sort intervals by starting time
        Arrays.sort(a, Comparator.comparingInt(i -> i[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            // If list is empty or no overlap
            if (ans.isEmpty() || a[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(a[i]);
            } 
            // Overlapping intervals
            else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], a[i][1]);
            }
        }

        // Convert list to array
        return ans.toArray(new int[ans.size()][]);
    }
}
