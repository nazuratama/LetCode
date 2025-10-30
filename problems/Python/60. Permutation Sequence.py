class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        fact = [1] * (n + 1)
        for i in range(2, n + 1):
            fact[i] = fact[i - 1] * i

        nums = [str(i) for i in range(1, n + 1)]
        res = []
        k -= 1

        for i in range(n, 0, -1):
            idx = k // fact[i - 1]
            k %= fact[i - 1]
            res.append(nums.pop(idx))
            
        return "".join(res)