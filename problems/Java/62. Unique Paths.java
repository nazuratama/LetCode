class Solution {
    public int uniquePaths(int m, int n) {
        long N = m + n - 2;
        long K = Math.min(m - 1, n - 1);
        long res = 1;

        for (int i = 0; i < K; ++i) {
            res = res * (N - i) / (i + 1);
        }
        
        return (int) res;
    }
}