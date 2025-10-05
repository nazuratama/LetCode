impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        let imax = i32::MAX;
        let imin = i32::MIN;
        let b = s.as_bytes();
        let n = b.len();
        let mut i: usize = 0;

        while i < n && b[i] == b' ' {
            i += 1;
        }

        let mut sgn: i32 = 1;
        if i < n && (b[i] == b'+' || b[i] == b'-') {
            if b[i] == b'-' {
                sgn = -1;
            }
            i += 1;
        }
        
        let mut res: i32 = 0;
        while i < n && b[i] >= b'0' && b[i] <= b'9' {
            let dig = (b[i] - b'0') as i32;

            if res > imax / 10 || (res == imax / 10 && dig > 7) {
                return if sgn == 1 { imax } else { imin };
            }
            
            res = res * 10 + dig;
            i += 1;
        }

        sgn * res
    }
}