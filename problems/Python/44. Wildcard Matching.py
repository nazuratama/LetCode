class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        slen, plen = len(s), len(p)
        sp, pp = 0, 0
        star = -1
        mtch = 0

        while sp < slen:
            if pp < plen and (p[pp] == '?' or p[pp] == s[sp]):
                sp += 1
                pp += 1
            elif pp < plen and p[pp] == '*':
                star = pp
                mtch = sp
                pp += 1
            elif star != -1:
                pp = star + 1
                mtch += 1
                sp = mtch
            else:
                return False

        while pp < plen and p[pp] == '*':
            pp += 1

        return pp == plen