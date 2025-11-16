class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        path = []

        def bt(start):
            if len(path) == k:
                res.append(list(path))
                return

            for i in range(start, n + 1):
                path.append(i)
                bt(i + 1)
                path.pop()
        
        bt(1)
        return res