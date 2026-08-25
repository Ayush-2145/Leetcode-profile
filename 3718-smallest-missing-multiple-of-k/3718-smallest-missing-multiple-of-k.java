class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        boolean t = false;
        int m = 0;
        for(int i = 1; i <= n; i++){
             m = k * i;
            for(int j = 0; j<n; j++){
                 if(nums[j] == m){
                    t = true;
                    break;
                 }
            }
            if(t != true) return m;
            else t = false;
        }
        return m + k;
    }
}