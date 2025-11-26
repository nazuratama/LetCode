class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char, int> map;
        int res = 0;
        int l = 0;

        for (int r = 0; r < s.length(); ++r) {
            char c = s[r];
            if (map.count(c) && map[c] >= l) {
                l = map[c] + 1;
            }
            map[c] = r;
            res = max(res, r - l + 1);
        }
        return res;
    }
};
