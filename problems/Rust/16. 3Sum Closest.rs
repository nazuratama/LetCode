impl Solution {
    pub fn three_sum_closest(mut nums: Vec<i32>, target: i32) -> i32 {
        nums.sort_unstable();
        let mut res = nums[0] + nums[1] + nums[2];

        for i in 0..nums.len() - 2 {
            let mut l = i + 1;
            let mut r = nums.len() - 1;
            while l < r {
                let csum = nums[i] + nums[l] + nums[r];
                if (csum - target).abs() < (res - target).abs() {
                    res = csum;
                }

                if csum < target {
                    l += 1;
                } else if csum > target {
                    r -= 1;
                } else {
                    return csum;
                }
            }
        }
        res
    }
}