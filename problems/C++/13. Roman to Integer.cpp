class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> rmap = {
            {'I', 1}, 
            {'V', 5}, 
            {'X', 10}, 
            {'L', 50}, 
            {'C', 100}, 
            {'D', 500}, 
            {'M', 1000}
        };
        
        int res = 0;
        int prev = 0;
        
        for (int i = s.length() - 1; i >= 0; --i) {
            int val = rmap[s[i]];
            if (val < prev) {
                res -= val;
            } else {
                res += val;
            }
            prev = val;
        }
        return res;
    }
};
