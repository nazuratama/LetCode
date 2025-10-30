class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> fact(n + 1, 1);
        for (int i = 2; i <= n; ++i) {
            fact[i] = fact[i - 1] * i;
        }

        vector<int> nums(n);
        iota(nums.begin(), nums.end(), 1);

        string res = "";
        k--;

        for (int i = n; i > 0; --i) {
            int idx = k / fact[i - 1];
            k %= fact[i - 1];
            res += to_string(nums[idx]);
            nums.erase(nums.begin() + idx);
        }

        return res;
    }
};