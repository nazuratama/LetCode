use std::cmp;

impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        if nums1.len() > nums2.len() {
            return Solution::find_median_sorted_arrays(nums2, nums1);
        }

        let m = nums1.len();
        let n = nums2.len();
        let mut l = 0;
        let mut h = m;

        while l <= h {
            let p1 = (l + h) / 2;
            let p2 = (m + n + 1) / 2 - p1;

            let ml1 = if p1 == 0 { i32::MIN } else { nums1[p1 - 1] };
            let mr1 = if p1 == m { i32::MAX } else { nums1[p1] };
            let ml2 = if p2 == 0 { i32::MIN } else { nums2[p2 - 1] };
            let mr2 = if p2 == n { i32::MAX } else { nums2[p2] };

            if ml1 <= mr2 && ml2 <= mr1 {
                if (m + n) % 2 == 0 {
                    return (cmp::max(ml1, ml2) as f64 + cmp::min(mr1, mr2) as f64) / 2.0;
                } else {
                    return cmp::max(ml1, ml2) as f64;
                }
            } else if ml1 > mr2 {
                h = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }
        0.0
    }
}
