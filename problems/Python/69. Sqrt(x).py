class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        l, r = 1, x
        res = 0
        while l <= r:
            mid = l + (r - l) // 2
            if mid <= x // mid:
                res = mid
                l = mid + 1
            else:
                r = mid - 1
        return res