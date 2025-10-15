class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []
        used = [False] * len(nums)

        def bt():
            if len(path) == len(nums):
                res.append(list(path))
                return

            for i in range(len(nums)):
                if not used[i]:
                    used[i] = True
                    path.append(nums[i])
                    bt()
                    path.pop()
                    used[i] = False
        
        bt()
        return res