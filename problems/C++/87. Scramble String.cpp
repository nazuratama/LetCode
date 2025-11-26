class Solution {
public:
    unordered_map<string, bool> memo;

    bool isScramble(string s1, string s2) {
        string key = s1 + "#" + s2;
        if (memo.count(key)) return memo[key];
        if (s1 == s2) return true;
        
        string temp1 = s1, temp2 = s2;
        sort(temp1.begin(), temp1.end());
        sort(temp2.begin(), temp2.end());
        if (temp1 != temp2) return false;

        int n = s1.length();
        for (int i = 1; i < n; ++i) {
            bool no_swap = isScramble(s1.substr(0, i), s2.substr(0, i)) &&
                           isScramble(s1.substr(i), s2.substr(i));
            if (no_swap) return memo[key] = true;
            
            bool swap = isScramble(s1.substr(0, i), s2.substr(n - i)) &&
                        isScramble(s1.substr(i), s2.substr(0, n - i));
            if (swap) return memo[key] = true;
        }

        return memo[key] = false;
    }
};