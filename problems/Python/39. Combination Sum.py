class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def bt(rem, path, start):
            if rem == 0:
                res.append(list(path))
                return
            if rem < 0:
                return

            for i in range(start, len(candidates)):
                path.append(candidates[i])
                bt(rem - candidates[i], path, i)
                path.pop()

        bt(target, [], 0)
        return res