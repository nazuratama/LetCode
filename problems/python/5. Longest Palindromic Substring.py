class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        st = 0
        en = 0

        for i in range(len(s)):
            len1 = self.expd(s, i, i)
            len2 = self.expd(s, i, i + 1)
            mlen = max(len1, len2)

            if mlen > en - st:
                st = i - (mlen - 1) // 2
                en = i + mlen // 2
        
        return s[st:en + 1]

    def expd(self, s: str, l: int, r: int) -> int:
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1