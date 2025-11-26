class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> dict(256, -1);
        int res = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (dict[s[i]] > -1) {
                start = max(start, dict[s[i]] + 1);
            }
            dict[s[i]] = i;
            res = max(res, i - start + 1);
        }
        return res;
    }
};