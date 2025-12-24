class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 1; j--) {
                if (sc[i] == tc[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}