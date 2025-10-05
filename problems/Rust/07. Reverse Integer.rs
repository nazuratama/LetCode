impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let mut rev = 0;
        let mut x = x;

        while x != 0 {
            let dig = x % 10;
            x /= 10;

            if rev > i32::MAX / 10 || (rev == i32::MAX / 10 && dig > 7) {
                return 0;
            }
            if rev < i32::MIN / 10 || (rev == i32::MIN / 10 && dig < -8) {
                return 0;
            }
            
            rev = rev * 10 + dig;
        }
        rev
    }
}