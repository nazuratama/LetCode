class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> d(wordList.begin(), wordList.end());
        if (d.find(endWord) == d.end()) return 0;
        
        unordered_set<string> s1, s2;
        s1.insert(beginWord);
        s2.insert(endWord);
        
        int stp = 1;
        
        while (!s1.empty() && !s2.empty()) {
            if (s1.size() > s2.size()) swap(s1, s2);
            
            unordered_set<string> nxt;
            for (string w : s1) {
                for (int i = 0; i < w.size(); ++i) {
                    char org = w[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        w[i] = c;
                        if (s2.count(w)) return stp + 1;
                        if (d.count(w)) {
                            nxt.insert(w);
                            d.erase(w);
                        }
                    }
                    w[i] = org;
                }
            }
            s1 = nxt;
            stp++;
        }
        return 0;
    }
};