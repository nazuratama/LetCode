class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        int sp = 0, pp = 0;
        int star = -1, mtch = 0;

        while (sp < slen) {
            if (pp < plen && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp))) {
                sp++;
                pp++;
            } else if (pp < plen && p.charAt(pp) == '*') {
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

        while (pp < plen && p.charAt(pp) == '*') {
            pp++;
        }

        return pp == plen;
    }
}