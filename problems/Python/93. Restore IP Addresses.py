class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        path = []

        def bt(start):
            if len(path) == 4 and start == len(s):
                res.append(".".join(path))
                return
            if len(path) >= 4:
                return

            for i in range(start, min(start + 3, len(s))):
                sub = s[start:i+1]
                if len(sub) > 1 and sub[0] == '0':
                    continue
                if int(sub) <= 255:
                    path.append(sub)
                    bt(i + 1)
                    path.pop()
        
        bt(0)
        return res