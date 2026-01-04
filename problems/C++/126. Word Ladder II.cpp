class Solution {
    unordered_map<string, vector<string>> mp;
    vector<vector<string>> res;
    string beginWord;

public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        this->beginWord = beginWord;
        unordered_set<string> d(wordList.begin(), wordList.end()); 
        if (d.find(endWord) == d.end()) return res;

        unordered_set<string> cur;
        cur.insert(beginWord);
        bool fnd = false;

        while (!cur.empty() && !fnd) {
            for (const string& w : cur) d.erase(w);
            unordered_set<string> nxt;

            for (const string& w : cur) {
                string tmp = w;
                for (int i = 0; i < tmp.size(); ++i) {
                    char old = tmp[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        tmp[i] = c;
                        if (d.count(tmp)) {
                            if (tmp == endWord) fnd = true;
                            nxt.insert(tmp);
                            mp[tmp].push_back(w);
                        }
                    }
                    tmp[i] = old;
                }
            }
            cur = nxt;
        }

        if (fnd) {
            vector<string> p = {endWord};
            dfs(endWord, p);
        }
        return res;
    }

    void dfs(string& w, vector<string>& p) {
        if (w == beginWord) {
            vector<string> tm = p;
            reverse(tm.begin(), tm.end()); 
            res.push_back(tm);
            return;
        }
        for (string& par : mp[w]) {
            p.push_back(par);
            dfs(par, p);
            p.pop_back();
        }
    }
};