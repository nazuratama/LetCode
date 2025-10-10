class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []

        def bt(rem, path, start):
            if rem == 0:
                res.append(list(path))
                return
            if rem < 0:
                return

            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i-1]:
                    continue
                
                path.append(candidates[i])
                bt(rem - candidates[i], path, i + 1)
                path.pop()

        bt(target, [], 0)
        return res
