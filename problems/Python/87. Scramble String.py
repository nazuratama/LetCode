class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        memo = {}
        def solve(a, b):
            if (a, b) in memo:
                return memo[(a, b)]
            if a == b:
                return True
            if sorted(a) != sorted(b):
                return False

            n = len(a)
            for i in range(1, n):
                no_swap = solve(a[:i], b[:i]) and solve(a[i:], b[i:])
                if no_swap:
                    memo[(a, b)] = True
                    return True
                
                swap = solve(a[:i], b[n-i:]) and solve(a[i:], b[:n-i])
                if swap:
                    memo[(a, b)] = True
                    return True
            
            memo[(a, b)] = False
            return False

        return solve(s1, s2)