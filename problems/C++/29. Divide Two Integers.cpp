class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }
        
        int sgn = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long long dvd = llabs((long long)dividend);
        long long dvs = llabs((long long)divisor);
        long long res = 0;
        
        while (dvd >= dvs) {
            long long temp = dvs, mult = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                mult <<= 1;
            }
            dvd -= temp;
            res += mult;
        }
        
        return (int)(sgn * res);
    }
}; 