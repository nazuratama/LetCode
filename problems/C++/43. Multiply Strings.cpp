#include <string>
#include <vector>

class Solution {
public:
    std::string multiply(std::string num1, std::string num2) {
        if (num1 == "0" || num2 == "0") {
            return "0";
        }

        int n = num1.length(), m = num2.length();
        std::vector<int> res(n + m, 0);

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int prod = (num1[i] - '0') * (num2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;
                
                int sum = prod + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        std::string s = "";
        int i = 0;
        while (i < res.size() && res[i] == 0) {
            i++;
        }
        while (i < res.size()) {
            s += std::to_string(res[i]);
            i++;
        }
        return s;
    }
};