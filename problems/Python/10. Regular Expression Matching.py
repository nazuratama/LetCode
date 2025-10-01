class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        cache = {}

        def dfs(i, j):
            if (i, j) in cache:
                return cache[(i, j)]
            
            if j == len(p):
                return i == len(s)

            m = i < len(s) and (p[j] == s[i] or p[j] == '.')

            if (j + 1) < len(p) and p[j + 1] == '*':
                res = dfs(i, j + 2) or (m and dfs(i + 1, j))
                cache[(i, j)] = res
                return res

            if m:
                res = dfs(i + 1, j + 1)
                cache[(i, j)] = res
                return res

            cache[(i, j)] = False
            return False

        return dfs(0, 0)