class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)

        m, n = len(nums1), len(nums2)
        l, h = 0, m

        while l <= h:
            p1 = (l + h) // 2
            p2 = (m + n + 1) // 2 - p1

            ml1 = nums1[p1 - 1] if p1 != 0 else -1000001
            mr1 = nums1[p1] if p1 != m else 1000001
            ml2 = nums2[p2 - 1] if p2 != 0 else -1000001
            mr2 = nums2[p2] if p2 != n else 1000001

            if ml1 <= mr2 and ml2 <= mr1:
                if (m + n) % 2 == 0:
                    return (max(ml1, ml2) + min(mr1, mr2)) / 2.0
                else:
                    return float(max(ml1, ml2))
            elif ml1 > mr2:
                h = p1 - 1
            else:
                l = p1 + 1
        
        return 0.0