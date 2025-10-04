impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        if num_rows == 1 || num_rows as usize >= s.len() {
            return s;
        }

        let n_rows = num_rows as usize;
        let mut res: Vec<String> = vec![String::new(); n_rows];
        let mut row: usize = 0;
        let mut down = false;

        for c in s.chars() {
            res[row].push(c);
            if row == 0 || row == n_rows - 1 {
                down = !down;
            }
            if down {
                row += 1;
            } else {
                row -= 1;
            }
        }
        res.join("")
    }
}