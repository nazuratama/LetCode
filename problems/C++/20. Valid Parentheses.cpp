class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        unordered_map<char, char> cmap = {{')', '('}, {'}', '{'}, {']', '['}};
        
        for (char c : s) {
            if (cmap.count(c)) {
                if (stk.empty() || stk.top() != cmap[c]) {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.empty();
    }
};