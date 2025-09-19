class Solution:
    def findMedianSortedArrays(self, n1: List[int], n2: List[int]) -> float:
        if len(n1) > len(n2):
            return self.findMedianSortedArrays(n2, n1)

        m, n = len(n1), len(n2)
        l, h = 0, m

        while l <= h:
            p1 = (l + h) // 2
            p2 = (m + n + 1) // 2 - p1

            ml1 = n1[p1 - 1] if p1 != 0 else -1000001
            mr1 = n1[p1] if p1 != m else 1000001
            ml2 = n2[p2 - 1] if p2 != 0 else -1000001
            mr2 = n2[p2] if p2 != n else 1000001

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