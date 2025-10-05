impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 || (x % 10 == 0 && x != 0) {
            return false;
        }

        let mut x = x;
        let mut revh = 0;
        while x > revh {
            revh = revh * 10 + x % 10;
            x /= 10;
        }

        x == revh || x == revh / 10
    }
}