class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        imax = 2**31 - 1
        imin = -2**31

        if dividend == imin and divisor == -1:
            return imax

        sgn = -1 if (dividend < 0) ^ (divisor < 0) else 1
        dvd = abs(dividend)
        dvs = abs(divisor)
        res = 0
        
        while dvd >= dvs:
            temp, mult = dvs, 1
            while dvd >= (temp << 1):
                temp <<= 1
                mult <<= 1
            dvd -= temp
            res += mult
            
        return sgn * res