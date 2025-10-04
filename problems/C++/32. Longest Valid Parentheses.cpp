class Solution {
public:
    int longestValidParentheses(string s) {
        int l = 0, r = 0, res = 0;

        for (char c : s) {
            if (c == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                res = max(res, 2 * r);
            } else if (r > l) {
                l = 0;
                r = 0;
            }
        }

        l = 0;
        r = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s[i];
            if (c == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                res = max(res, 2 * l);
            } else if (l > r) {
                l = 0;
                r = 0;
            }
        }
        return res;
    }
};
