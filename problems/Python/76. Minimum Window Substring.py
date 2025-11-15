class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "" or len(s) < len(t):
            return ""

        tmap = {}
        for c in t:
            tmap[c] = tmap.get(c, 0) + 1
        
        need = len(tmap)
        have = 0
        wmap = {}
        res = [-1, -1]
        rlen = float("inf")
        l = 0

        for r in range(len(s)):
            c = s[r]
            wmap[c] = wmap.get(c, 0) + 1

            if c in tmap and wmap[c] == tmap[c]:
                have += 1

            while have == need:
                if (r - l + 1) < rlen:
                    res = [l, r]
                    rlen = r - l + 1
                
                lc = s[l]
                wmap[lc] -= 1
                if lc in tmap and wmap[lc] < tmap[lc]:
                    have -= 1
                l += 1
        
        l, r = res
        return s[l:r+1] if rlen != float("inf") else ""