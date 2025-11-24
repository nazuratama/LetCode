class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] h = new int[n];
        int area = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') {
                    h[c]++;
                } else {
                    h[c] = 0;
                }
            }
            area = Math.max(area, lrh(h));
        }
        return area;
    }

    private int lrh(int[] heights) {
        Deque<int[]> stk = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stk.isEmpty() && stk.peek()[1] > heights[i]) {
                int[] bar = stk.pop();
                area = Math.max(area, bar[1] * (i - bar[0]));
                start = bar[0];
            }
            stk.push(new int[]{start, heights[i]});
        }
        while (!stk.isEmpty()) {
            int[] bar = stk.pop();
            area = Math.max(area, bar[1] * (heights.length - bar[0]));
        }
        return area;
    }
}