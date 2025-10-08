class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
            while (j < res.length()) {
                int cnt = 1;
                while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    cnt++;
                    j++;
                }
                next.append(cnt);
                next.append(res.charAt(j));
                j++;
            }
            res = next.toString();
        }
        return res;
    }
}