class Solution {
    public int myAtoi(String s) {
        int imax = Integer.MAX_VALUE;
        int imin = Integer.MIN_VALUE;
        
        int i = 0;
        int n = s.length();
        
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        int sgn = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sgn = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        int res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int dig = s.charAt(i) - '0';
            
            if (res > imax / 10 || (res == imax / 10 && dig > 7)) {
                return (sgn == 1) ? imax : imin;
            }
            
            res = res * 10 + dig;
            i++;
        }
        
        return sgn * res;
    }
}
