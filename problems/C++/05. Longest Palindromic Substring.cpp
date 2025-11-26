class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) {
            return "";
        }
        int st = 0, en = 0;

        for (int i = 0; i < s.length(); ++i) {
            int len1 = expd(s, i, i);
            int len2 = expd(s, i, i + 1);
            int mlen = max(len1, len2);
            if (mlen > en - st) {
                st = i - (mlen - 1) / 2;
                en = i + mlen / 2;
            }
        }
        return s.substr(st, en - st + 1);
    }

private:
    int expd(const string& s, int l, int r) {
        while (l >= 0 && r < s.length() && s[l] == s[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
};
