class Solution {
    public int[] findEvenNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int d : digits)
            freq[d]++;

        List<Integer> list = new ArrayList<>();

        for (int num = 100; num <= 998; num += 2) {

            int[] copy = freq.clone();

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            if (copy[a]-- <= 0) continue;
            if (copy[b]-- <= 0) continue;
            if (copy[c]-- <= 0) continue;

            list.add(num);
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}