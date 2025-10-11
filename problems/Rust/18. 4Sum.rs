impl Solution {
    pub fn four_sum(mut nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        nums.sort_unstable();
        let mut res = Vec::new();
        let n = nums.len();
        if n < 4 { return res; }

        for i in 0..n - 3 {
            if i > 0 && nums[i] == nums[i - 1] { continue; }
            for j in i + 1..n - 2 {
                if j > i + 1 && nums[j] == nums[j - 1] { continue; }

                let mut l = j + 1;
                let mut r = n - 1;
                while l < r {
                    let csum = (nums[i] as i64) + (nums[j] as i64) + (nums[l] as i64) + (nums[r] as i64);
                    match csum.cmp(&(target as i64)) {
                        std::cmp::Ordering::Less => l += 1,
                        std::cmp::Ordering::Greater => r -= 1,
                        std::cmp::Ordering::Equal => {
                            res.push(vec![nums[i], nums[j], nums[l], nums[r]]);
                            l += 1;
                            r -= 1;
                            while l < r && nums[l] == nums[l - 1] { l += 1; }
                            while l < r && nums[r] == nums[r + 1] { r -= 1; }
                        }
                    }
                }
            }
        }
        res
    }
}