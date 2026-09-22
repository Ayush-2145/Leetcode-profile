class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        int n = g.length;
        int m = s.length;
        ArrayList<Integer> c = new ArrayList<>();
        Arrays.sort(g);
        Arrays.sort(s);
        for(int k = 0; k<m; k++){
            c.add(s[k]);
        }

        

        for(int i = 0; i < c.size(); i++){
            if(cnt < n && c.get(i) >= g[cnt]) cnt++;
        }
        return cnt;
    }
}