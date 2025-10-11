use std::collections::HashMap;

impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        if digits.is_empty() {
            return vec![];
        }

        let dmap: HashMap<char, &str> = [
            ('2', "abc"), 
            ('3', "def"), 
            ('4', "ghi"), 
            ('5', "jkl"),
            ('6', "mno"), 
            ('7', "pqrs"), 
            ('8', "tuv"), 
            ('9', "wxyz"),
        ].iter().cloned().collect();
        
        let mut res = vec![String::new()];

        for d in digits.chars() {
            let mut temp = Vec::new();
            let ltrs = dmap[&d];
            for path in &res {
                for c in ltrs.chars() {
                    temp.push(format!("{}{}", path, c));
                }
            }
            res = temp;
        }
        res
    }
}