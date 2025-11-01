class Solution {
public:
    int uniquePaths(int m, int n) {
        long long N = m + n - 2;
        long long K = min(m - 1, n - 1);
        long long res = 1;

        for (int i = 0; i < K; ++i) {
            res = res * (N - i) / (i + 1);
        }
        
        return (int)res;
    }
};