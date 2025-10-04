class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string path = "";
        bt(n, 0, 0, path, res);
        return res;
    }

private:
    void bt(int n, int op, int cl, string& path, vector<string>& res) {
        if (path.length() == n * 2) {
            res.push_back(path);
            return;
        }

        if (op < n) {
            path.push_back('(');
            bt(n, op + 1, cl, path, res);
            path.pop_back();
        }

        if (cl < op) {
            path.push_back(')');
            bt(n, op, cl + 1, path, res);
            path.pop_back();
        }
    }
};