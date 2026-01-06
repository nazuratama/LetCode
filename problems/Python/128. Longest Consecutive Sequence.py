class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        mx = 0
        
        for n in s:
            if n - 1 not in s:
                cur = n
                l = 1
                while cur + 1 in s:
                    cur += 1
                    l += 1
                if l > mx:
                    mx = l
        return mx