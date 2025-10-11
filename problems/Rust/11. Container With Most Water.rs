use std::cmp;

impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut l = 0;
        let mut r = height.len() - 1;
        let mut area = 0;

        while l < r {
            let h = cmp::min(height[l], height[r]);
            area = cmp::max(area, (r - l) as i32 * h);
            
            if height[l] < height[r] {
                l += 1;
            } else {
                r -= 1;
            }
        }
        area
    }
}
