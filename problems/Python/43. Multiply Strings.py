class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if "0" in (num1, num2):
            return "0"
        
        n, m = len(num1), len(num2)
        res = [0] * (n + m)
        
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                prod = int(num1[i]) * int(num2[j])
                p1, p2 = i + j, i + j + 1
                
                sum_val = prod + res[p2]
                res[p2] = sum_val % 10
                res[p1] += sum_val // 10

        i = 0
        while i < len(res) and res[i] == 0:
            i += 1
            
        return "".join(map(str, res[i:]))