class Solution {
public:
    bool isPalindrome(int x) {
        int revh = 0;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        while (x > revh) {
            revh = revh * 10 + x % 10;
            x /= 10;
        }

        return x == revh || x == revh / 10;
    }
};