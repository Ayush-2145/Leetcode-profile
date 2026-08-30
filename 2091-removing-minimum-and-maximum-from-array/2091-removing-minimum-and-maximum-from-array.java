class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int left = Math.max(minIndex, maxIndex) + 1;
        int right = n - Math.min(minIndex, maxIndex);
        int leftRight = minIndex + 1 + (n - maxIndex);
        int rightLeft = maxIndex + 1 + (n - minIndex);

        return Math.min(
            Math.min(left, right),
            Math.min(leftRight, rightLeft)
        );
    }
}
