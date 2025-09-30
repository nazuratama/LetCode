class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []
            
        wlen = len(words[0])
        n = len(words)
        slen = len(s)
        tlen = wlen * n
        res = []
        wmap = {}
        for w in words:
            wmap[w] = wmap.get(w, 0) + 1

        for i in range(wlen):
            l = i
            smap = {}
            cnt = 0
            for r in range(i, slen - wlen + 1, wlen):
                word = s[r:r+wlen]
                if word in wmap:
                    smap[word] = smap.get(word, 0) + 1
                    cnt += 1
                    while smap[word] > wmap[word]:
                        lword = s[l:l+wlen]
                        smap[lword] -= 1
                        cnt -= 1
                        l += wlen
                    if cnt == n:
                        res.append(l)
                else:
                    smap.clear()
                    cnt = 0
                    l = r + wlen
        return res