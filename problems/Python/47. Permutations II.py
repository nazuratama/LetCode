class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []
        nums.sort()
        used = [False] * len(nums)

        def bt():
            if len(path) == len(nums):
                res.append(list(path))
                return

            for i in range(len(nums)):
                if used[i] or (i > 0 and nums[i] == nums[i-1] and not used[i-1]):
                    continue
                
                used[i] = True
                path.append(nums[i])
                bt()
                path.pop()
                used[i] = False
        
        bt()
        return res