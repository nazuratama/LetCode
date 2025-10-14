class Solution {
public:
    bool isMatch(string s, string p) {
        int slen = s.length(), plen = p.length();
        int sp = 0, pp = 0;
        int star = -1, mtch = 0;

        while (sp < slen) {
            if (pp < plen && (p[pp] == '?' || p[pp] == s[sp])) {
                sp++;
                pp++;
            } else if (pp < plen && p[pp] == '*') {
                star = pp;
                mtch = sp;
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                mtch++;
                sp = mtch;
            } else {
                return false;
            }
        }

        while (pp < plen && p[pp] == '*') {
            pp++;
        }

        return pp == plen;
    }
};