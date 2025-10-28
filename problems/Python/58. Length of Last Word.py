class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        len = 0
        for i in range(len(s) - 1, -1, -1):
            if s[i] != ' ':
                len += 1
            elif len > 0:
                return len
        return len