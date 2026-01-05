class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        d = set(wordList)
        if endWord not in d:
            return 0
        
        s1 = {beginWord}
        s2 = {endWord}
        stp = 1
        
        while s1 and s2:
            if len(s1) > len(s2):
                s1, s2 = s2, s1
            
            nxt = set()
            for w in s1:
                wa = list(w)
                for i in range(len(wa)):
                    org = wa[i]
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        wa[i] = c
                        nw = "".join(wa)
                        if nw in s2:
                            return stp + 1
                        if nw in d:
                            nxt.add(nw)
                            d.remove(nw)
                    wa[i] = org
            s1 = nxt
            stp += 1
            
        return 0