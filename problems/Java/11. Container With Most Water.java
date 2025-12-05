class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;

        while (l < r) {
            int h = height[l] < height[r] ? height[l] : height[r];
            int tmp = (r - l) * h;
            
            if (tmp > area) area = tmp;

            while (l < r && height[l] <= h) {
                l++;
            }
            while (l < r && height[r] <= h) {
                r--;
            }
        }
        return area;
    }
}