class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        vector<string> path;
        bt(s, 0, path, res);
        return res;
    }

private:
    void bt(const string& s, int start, vector<string>& path, vector<string>& res) {
        if (path.size() == 4 && start == s.length()) {
            res.push_back(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            return;
        }
        if (path.size() >= 4 || start >= s.length()) {
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); ++i) {
            string sub = s.substr(start, i - start + 1);
            if (sub.length() > 1 && sub[0] == '0') {
                continue;
            }
            if (stoi(sub) <= 255) {
                path.push_back(sub);
                bt(s, i + 1, path, res);
                path.pop_back();
            }
        }
    }
};