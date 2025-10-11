use std::collections::HashMap;

impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        let rmap: HashMap<char, i32> = [
            ('I', 1), 
            ('V', 5), 
            ('X', 10), 
            ('L', 50),
            ('C', 100), 
            ('D', 500), 
            ('M', 1000),
        ].iter().cloned().collect();
        
        let mut res = 0;
        let mut prev = 0;
        
        for c in s.chars().rev() {
            let val = rmap[&c];
            if val < prev {
                res -= val;
            } else {
                res += val;
            }
            prev = val;
        }
        res
    }
}