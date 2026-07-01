class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int mod = 0;

            for (char ch : word.toCharArray()) {
                mod = (mod + weights[ch - 'a']) % 26;
            }

            ans.append((char) ('a' + (25 - mod)));
        }

        return ans.toString();
    }
}