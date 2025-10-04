class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        if (s.empty() || words.empty()) return {};

        int wlen = words[0].length();
        int n = words.size();
        int slen = s.length();
        int tlen = wlen * n;
        vector<int> res;
        unordered_map<string, int> wmap;

        for (const string& w : words) {
            wmap[w]++;
        }

        for (int i = 0; i < wlen; ++i) {
            unordered_map<string, int> smap;
            int l = i;
            int cnt = 0;
            for (int r = i; r <= slen - wlen; r += wlen) {
                string word = s.substr(r, wlen);
                if (wmap.count(word)) {
                    smap[word]++;
                    cnt++;
                    while (smap[word] > wmap[word]) {
                        string lword = s.substr(l, wlen);
                        smap[lword]--;
                        cnt--;
                        l += wlen;
                    }
                    if (cnt == n) {
                        res.push_back(l);
                    }
                } else {
                    smap.clear();
                    cnt = 0;
                    l = r + wlen;
                }
            }
        }
        return res;
    }
};