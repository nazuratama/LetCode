class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1 == "0" || num2 == "0") {
            return "0";
        }

        int n = num1.length(), m = num2.length();
        vector<int> res(n + m, 0);

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int prod = (num1[i] - '0') * (num2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;
                
                int sum = prod + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        string s = "";
        int i = 0;
        while (i < res.size() && res[i] == 0) {
            i++;
        }
        while (i < res.size()) {
            s += to_string(res[i]);
            i++;
        }
        return s;
    }
};