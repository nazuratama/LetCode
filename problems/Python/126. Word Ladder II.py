class Solution:
    def findLadders(self, beg: str, end: str, wl: List[str]) -> List[List[str]]:
        d = set(wl)
        if end not in d: return []
        
        cur = {beg}
        mp = collections.defaultdict(list)
        
        while cur:
            if end in cur: break
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
            if w == beg:
                res.append([beg] + p[::-1])
                return
            for par in mp[w]:
                dfs(par, p + [w])
                
        if end in mp:
            dfs(end, [])
            
        return res