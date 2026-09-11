class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int m = n - 1;

        if (n == 1) {
            return nums[0];
        }
        if(n==2) return Math.max(nums[0],nums[1]);

        int[] dp = new int[m];
        int[] dp1 = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp1[0] = nums[1];
        dp1[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < m; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        for (int j = 3; j < n; j++) {
            dp1[j - 1] = Math.max(dp1[j - 2], nums[j] + dp1[j - 3]);
        }

        return Math.max(dp[m - 1],dp1[n - 2]);        
    }
}