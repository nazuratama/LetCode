class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;

        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r--;

            if (t > b) break;
            
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            b--;

            if (l > r) break;

            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}