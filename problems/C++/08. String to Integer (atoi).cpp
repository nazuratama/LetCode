class Solution {
public:
    int myAtoi(string s) {
        int imax = INT_MAX;
        int imin = INT_MIN;
        
        int i = 0;
        int n = s.length();
        
        while (i < n && s[i] == ' ') {
            i++;
        }
        
        int sgn = 1;
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            sgn = (s[i] == '-') ? -1 : 1;
            i++;
        }
        
        int res = 0;
        while (i < n && isdigit(s[i])) {
            int dig = s[i] - '0';
            
            if (res > imax / 10 || (res == imax / 10 && dig > 7)) {
                return (sgn == 1) ? imax : imin;
            }
            
            res = res * 10 + dig;
            i++;
        }
        
        return sgn * res;
    }
};