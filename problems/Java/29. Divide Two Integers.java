class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sgn = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long res = 0;

        while (dvd >= dvs) {
            long temp = dvs, mult = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                mult <<= 1;
            }
            dvd -= temp;
            res += mult;
        }

        return (int) (sgn * res);
    }
}
