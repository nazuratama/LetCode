class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        
        int n = num1.length(), m = num2.length();
        int[] res = new int[n + m];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                
                int sum = prod + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int dig : res) {
            if (!(sb.length() == 0 && dig == 0)) {
                sb.append(dig);
            }
        }
        return sb.toString();
    }
}