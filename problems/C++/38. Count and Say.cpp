class Solution {
public:
    string countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        string res = "1";
        for (int i = 2; i <= n; ++i) {
            string next = "";
            int j = 0;
            while (j < res.length()) {
                int cnt = 1;
                while (j + 1 < res.length() && res[j] == res[j + 1]) {
                    cnt++;
                    j++;
                }
                next += to_string(cnt) + res[j];
                j++;
            }
            res = next;
        }
        return res;
    }
};