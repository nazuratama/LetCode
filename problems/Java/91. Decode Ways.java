class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int two = 1;
        int one = 1;

        for (int i = 1; i < s.length(); i++) {
            int curr = 0;
            if (s.charAt(i) != '0') {
                curr += one;
            }

            char prev = s.charAt(i - 1);
            if (prev == '1' || (prev == '2' && s.charAt(i) <= '6')) {
                curr += two;
            }
            
            two = one;
            one = curr;
        }
        return one;
    }
}
