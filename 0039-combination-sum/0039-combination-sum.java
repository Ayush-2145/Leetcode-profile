class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), ans);
        return ans; 
    }
    private void backtrack(int idx, int[] arr, int target,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        // valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // invalid
        if (idx == arr.length || target < 0) {
            return;
        }

        // pick current element
        curr.add(arr[idx]);
        backtrack(idx, arr, target - arr[idx], curr, ans);

        // backtrack
        curr.remove(curr.size() - 1);

        // skip current element
        backtrack(idx + 1, arr, target, curr, ans);
    }
}