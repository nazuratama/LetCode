class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int h = m;

        while (l <= h) {
            int p1 = (l + h) / 2;
            int p2 = (m + n + 1) / 2 - p1;

            int ml1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int mr1 = (p1 == m) ? Integer.MAX_VALUE : nums1[p1];
            int ml2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int mr2 = (p2 == n) ? Integer.MAX_VALUE : nums2[p2];

            if (ml1 <= mr2 && ml2 <= mr1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(ml1, ml2) + Math.min(mr1, mr2)) / 2.0;
                } else {
                    return (double) Math.max(ml1, ml2);
                }
            } else if (ml1 > mr2) {
                h = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }
        return 0;
    }
}