class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > j) return false;
            j = Math.max(j , i + nums[i]);
                
           
        }
        return true;
    }
}