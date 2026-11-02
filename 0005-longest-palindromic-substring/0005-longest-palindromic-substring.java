class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String r ="";

        for(int i =0; i<n; i++){
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);

            if(odd.length() >r.length()){
                r =odd;
            }
            if(even.length() >r.length()){
                r=even;
            }

        }
        return r;
    }
    public String expand(String st, int l, int r){
        while(l>=0 && r<st.length() && st.charAt(l)==st.charAt(r)){
            l--;
            r++;
        }
        return st.substring(l+1,r);
    }
   
}