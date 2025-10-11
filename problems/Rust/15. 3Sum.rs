impl Solution {
    pub fn three_sum(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
        nums.sort_unstable();
        let mut res = Vec::new();
        let n = nums.len();

        for i in 0..n {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }

            let mut l = i + 1;
            let mut r = n - 1;
            while l < r {
                let tsum = nums[i] + nums[l] + nums[r];
                match tsum.cmp(&0) {
                    std::cmp::Ordering::Greater => r -= 1,
                    std::cmp::Ordering::Less => l += 1,
                    std::cmp::Ordering::Equal => {
                        res.push(vec![nums[i], nums[l], nums[r]]);
                        l += 1;
                        while l < r && nums[l] == nums[l - 1] {
                            l += 1;
                        }
                    }
                }
            }
        }
        res
    }
}