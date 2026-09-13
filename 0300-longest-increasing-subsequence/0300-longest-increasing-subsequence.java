class Solution {
    int[] cache;

    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length];

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(nums, i));
        }

        return ans;
    }

    private int dfs(int[] nums, int i) {
        if (cache[i] != 0) {
            return cache[i];
        }
        int res = 1;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                res = Math.max(res, 1 + dfs(nums, j));
            }
        }

        cache[i] = res;
        return res;
    }
}
