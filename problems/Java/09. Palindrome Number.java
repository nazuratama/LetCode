class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revh = 0;
        while (x > revh) {
            revh = revh * 10 + (x % 10);
            x /= 10;
        }

        return x == revh || x == revh / 10;
    }
}