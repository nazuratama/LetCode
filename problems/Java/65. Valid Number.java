class Solution {
    public boolean isNumber(String s) {
        boolean dig = false;
        boolean dot = false;
        boolean exp = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                dig = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && Character.toLowerCase(s.charAt(i-1)) != 'e') {
                    return false;
                }
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (Character.toLowerCase(c) == 'e') {
                if (exp || !dig) return false;
                exp = true;
                dig = false;
            } else {
                return false;
            }
        }
        return dig;
    }
}