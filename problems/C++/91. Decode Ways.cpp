class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') {
            return 0;
        }

        int two = 1;
        int one = 1;

        for (int i = 1; i < s.length(); ++i) {
            int curr = 0;
            if (s[i] != '0') {
                curr += one;
            }

            if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6')) {
                curr += two;
            }
            
            two = one;
            one = curr;
        }
        return one;
    }
};