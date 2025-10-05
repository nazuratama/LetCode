use std::collections::HashMap;

impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        let mut cache = HashMap::new();
        Self::dfs(0, 0, s.as_bytes(), p.as_bytes(), &mut cache)
    }

    fn dfs(i: usize, j: usize, s: &[u8], p: &[u8], cache: &mut HashMap<(usize, usize), bool>) -> bool {
        if let Some(&res) = cache.get(&(i, j)) {
            return res;
        }

        if j == p.len() {
            return i == s.len();
        }

        let m = i < s.len() && (p[j] == s[i] || p[j] == b'.');
        let res;

        if j + 1 < p.len() && p[j + 1] == b'*' {
            res = Self::dfs(i, j + 2, s, p, cache) || (m && Self::dfs(i + 1, j, s, p, cache));
        } else if m {
            res = Self::dfs(i + 1, j + 1, s, p, cache);
        } else {
            res = false;
        }

        cache.insert((i, j), res);
        res
    }
}