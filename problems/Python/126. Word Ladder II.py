class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        d = set(wordList)
        if endWord not in d: return []
        
        cur = {beginWord}
        mp = collections.defaultdict(list)
        
        while cur:
            if endWord in cur: break
            nxt = set()
            d -= cur
            for w in cur:
                for i in range(len(w)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        nw = w[:i] + c + w[i+1:]
                        if nw in d:
                            nxt.add(nw)
                            mp[nw].append(w)
            cur = nxt
            
        res = []
        def dfs(w, p):
            if w == beginWord:
                res.append([beginWord] + p[::-1])
                return
            for par in mp[w]:
                dfs(par, p + [w])
                
        if endWord in mp:
            dfs(endWord, [])
            
        return res