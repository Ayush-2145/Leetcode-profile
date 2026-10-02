
class Solution {
    public int minGroups(int[][] intervals) {
        int res = 0, cur = 0;
        int n = intervals.length;
        int[][] A = new int[n * 2][2];

        for (int i = 0; i < n; ++i) {
            A[i * 2] = new int[]{intervals[i][0], 1};
            A[i * 2 + 1] = new int[]{intervals[i][1] + 1, -1};
        }

        Arrays.sort(A, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int[] a : A) {
            cur += a[1];
            res = Math.max(res, cur);
        }

        return res;
    }
}

