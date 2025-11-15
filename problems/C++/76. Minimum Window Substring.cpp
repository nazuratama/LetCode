class Solution {
public:
    string minWindow(string s, string t) {
        if (t.empty() || s.length() < t.length()) {
            return "";
        }
        
        unordered_map<char, int> tmap;
        for (char c : t) {
            tmap[c]++;
        }

        int l = 0, rlen = -1, ridx = -1;
        int need = tmap.size(), have = 0;
        unordered_map<char, int> wmap;

        for (int r = 0; r < s.length(); ++r) {
            char c = s[r];
            wmap[c]++;

            if (tmap.count(c) && wmap[c] == tmap[c]) {
                have++;
            }

            while (have == need) {
                if (rlen == -1 || r - l + 1 < rlen) {
                    rlen = r - l + 1;
                    ridx = l;
                }
                char lc = s[l];
                wmap[lc]--;
                if (tmap.count(lc) && wmap[lc] < tmap[lc]) {
                    have--;
                }
                l++;
            }
        }
        return (rlen == -1) ? "" : s.substr(ridx, rlen);
    }
};