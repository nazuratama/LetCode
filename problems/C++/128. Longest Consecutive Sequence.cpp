class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> s(nums.begin(), nums.end());
        int mx = 0;
        
        for (int n : s) {
            if (s.find(n - 1) == s.end()) {
                int cur = n;
                int l = 1;
                while (s.count(cur + 1)) {
                    cur++;
                    l++;
                }
                mx = max(mx, l);
            }
        }
        return mx;
    }
};