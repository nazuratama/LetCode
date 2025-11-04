class Solution {
public:
    bool isNumber(string s) {
        bool dig = false;
        bool dot = false;
        bool exp = false;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s[i];
            
            if (isdigit(c)) {
                dig = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && tolower(s[i-1]) != 'e') {
                    return false;
                }
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (tolower(c) == 'e') {
                if (exp || !dig) return false;
                exp = true;
                dig = false;
            } else {
                return false;
            }
        }
        return dig;
    }
};