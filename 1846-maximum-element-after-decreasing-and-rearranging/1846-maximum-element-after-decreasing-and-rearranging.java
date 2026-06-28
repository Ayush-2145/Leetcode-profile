//Daily Problem

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;
        int[] freq = new int[n + 1];

        for (int num : arr) {
            freq[Math.min(num, n)]++;
        }

        int ans = 0;

        for (int value = 1; value <= n; value++) {
            while (freq[value]-- > 0) {
                ans = Math.min(ans + 1, value);
            }
        }

        return ans;
    }
}