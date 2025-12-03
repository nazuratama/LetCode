class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (chars[r] > left) {
                left = chars[r];
            }
            res = res > right - left + 1 ? res : right - left + 1;
            chars[r] = right + 1;
            right++;
        }
        return res;
    }
}