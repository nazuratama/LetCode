use std::cmp;

impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        if s.is_empty() {
            return String::new();
        }

        let b = s.as_bytes();
        let mut st = 0;
        let mut en = 0;

        for i in 0..b.len() {
            let len1 = Self::expd(b, i as isize, i as isize);
            let len2 = Self::expd(b, i as isize, i as isize + 1);
            let mlen = cmp::max(len1, len2);

            if mlen > en - st {
                st = i - (mlen - 1) / 2;
                en = i + mlen / 2;
            }
        }
        s[st..=en].to_string()
    }

    fn expd(b: &[u8], mut l: isize, mut r: isize) -> usize {
        let n = b.len() as isize;
        if l < 0 || r >= n {
            return 0;
        }
        while l >= 0 && r < n && b[l as usize] == b[r as usize] {
            l -= 1;
            r += 1;
        }
        (r - l - 1) as usize
    }
}