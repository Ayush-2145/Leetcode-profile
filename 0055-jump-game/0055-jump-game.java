class Solution {
    public Boolean[] memo;
    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return dfs(0,nums);
    }

    public boolean dfs(int i, int[] nums) {
        if(i >= nums.length - 1) return true;
        if(memo[i] != null) return memo[i];

        int furthest = Math.min(i + nums[i], nums.length - 1);
        for(int j = i + 1; j <= furthest; j++){
            if(dfs(j,nums)) return memo[i] = true;
        }
        return memo[i] = false;
    }
}