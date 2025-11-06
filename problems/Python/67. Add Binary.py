class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = []
        c = 0
        i, j = len(a) - 1, len(b) - 1

        while i >= 0 or j >= 0 or c:
            if i >= 0:
                c += int(a[i])
                i -= 1
            if j >= 0:
                c += int(b[j])
                j -= 1
            
            res.append(str(c % 2))
            c //= 2
            
        return "".join(reversed(res))