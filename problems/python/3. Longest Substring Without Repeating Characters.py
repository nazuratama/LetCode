class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cmap = {}
        res = 0
        l = 0

        for r, c in enumerate(s):
            if c in cmap and cmap[c] >= l:
                l = cmap[c] + 1
            
            cmap[c] = r
            res = max(res, r - l + 1)
            
        return res