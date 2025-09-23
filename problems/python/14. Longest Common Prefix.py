class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        for i, c in enumerate(strs[0]):
            for s2 in strs[1:]:
                if i >= len(s2) or s2[i] != c:
                    return strs[0][:i]
        
        return strs[0]