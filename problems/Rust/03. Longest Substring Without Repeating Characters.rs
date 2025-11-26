use std::collections::HashMap;
use std::cmp;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut map: HashMap<char, usize> = HashMap::new();
        let mut res = 0;
        let mut l: usize = 0;

        for (r, c) in s.char_indices() {
            if let Some(prev) = map.get(&c) {
                if *prev >= l {
                    l = *prev + 1;
                }
            }
            map.insert(c, r);
            res = cmp::max(res, r - l + 1);
        }
        res as i32
    }
}
