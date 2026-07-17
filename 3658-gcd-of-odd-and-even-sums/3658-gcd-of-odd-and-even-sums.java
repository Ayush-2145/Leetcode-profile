class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 1; i <= n; i++) {
           sumOdd += (2 * i - 1);
           sumEven += (2 * i);
        }
        int l = Math.min(sumOdd, sumEven);
        int fin_ans = 1;

        for (int ans = 1; ans <= l; ans++) {
            if (sumOdd % ans == 0 && sumEven % ans == 0) {
                fin_ans = ans;
            }
        }

        return fin_ans;
    }
}