class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stk = new ArrayDeque<>();
        int area = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stk.isEmpty() && stk.peek()[1] > heights[i]) {
                int[] bar = stk.pop();
                int idx = bar[0];
                int hgt = bar[1];
                area = Math.max(area, hgt * (i - idx));
                start = idx;
            }
            stk.push(new int[]{start, heights[i]});
        }
        
        while (!stk.isEmpty()) {
            int[] bar = stk.pop();
            int idx = bar[0];
            int hgt = bar[1];
            area = Math.max(area, hgt * (heights.length - idx));
        }
        
        return area;
    }
}