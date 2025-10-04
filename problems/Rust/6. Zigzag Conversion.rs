impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        if num_rows == 1 || num_rows as usize >= s.len() {
            return s;
        }

        let n_rows = num_rows as usize;
        let n = s.len();
        let b = s.as_bytes();
        let mut out = String::with_capacity(n);
        let cycle = 2 * n_rows - 2;

        for r in 0..n_rows {
            let mut j = r;
            while j < n {
                out.push(b[j] as char);
                if r != 0 && r != n_rows - 1 {
                    let k = j + cycle - 2 * r;
                    if k < n {
                        out.push(b[k] as char);
                    }
                }
                j += cycle;
            }
        }
        out
    }
}
