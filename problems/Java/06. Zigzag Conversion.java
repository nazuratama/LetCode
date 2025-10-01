class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = false;

        for (char c : s.toCharArray()) {
            res[row].append(c);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }

        StringBuilder finalRes = new StringBuilder();
        for (StringBuilder sb : res) {
            finalRes.append(sb);
        }
        return finalRes.toString();
    }
}