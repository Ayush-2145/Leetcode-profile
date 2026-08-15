class Solution {
    public int maximumLengthSubstring(String s) {
   
        int[] freq = new int[256];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch]++;

            while (freq[ch] > 2) {
                freq[s.charAt(left)]--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    
    }
}