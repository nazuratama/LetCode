class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stk;
        stringstream ss(path);
        string comp;

        while (getline(ss, comp, '/')) {
            if (comp == "..") {
                if (!stk.empty()) {
                    stk.pop_back();
                }
            } else if (!comp.empty() && comp != ".") {
                stk.push_back(comp);
            }
        }

        if (stk.empty()) {
            return "/";
        }

        string res = "";
        for (const string& s : stk) {
            res += "/" + s;
        }
        return res;
    }
};