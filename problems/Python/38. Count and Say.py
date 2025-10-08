class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        res = "1"
        for _ in range(n - 1):
            next_res = ""
            i = 0
            while i < len(res):
                cnt = 1
                while i + 1 < len(res) and res[i] == res[i + 1]:
                    cnt += 1
                    i += 1
                next_res += str(cnt) + res[i]
                i += 1
            res = next_res
            
        return res