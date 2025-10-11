impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.is_empty() {
            return String::new();
        }
        
        let first = strs[0].as_bytes();
        
        for (i, &c) in first.iter().enumerate() {
            for s2 in &strs[1..] {
                if i >= s2.len() || s2.as_bytes()[i] != c {
                    return strs[0][..i].to_string();
                }
            }
        }
        
        strs[0].clone()
    }
}