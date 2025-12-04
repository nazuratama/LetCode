class Solution {
    private int st = 0;
    private int en = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            expd(s, i, i);
            expd(s, i, i + 1);
        }
        return s.substring(st, en);
    }

    private void expd(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > en - st) {
            st = l + 1;
            en = r;
        }
    }
}
