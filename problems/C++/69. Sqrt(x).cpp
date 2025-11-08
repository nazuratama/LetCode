class Solution {
public:
    int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1, r = x;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
};