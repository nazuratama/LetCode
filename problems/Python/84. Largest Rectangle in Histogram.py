class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stk = []
        area = 0
        
        for i, h in enumerate(heights + [0]):
            start = i
            while stk and stk[-1][1] > h:
                idx, hgt = stk.pop()
                area = max(area, hgt * (i - idx))
                start = idx
            stk.append((start, h))
            
        return area