class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = self.find(nums, target, True)
        r = self.find(nums, target, False)
        return [l, r]

    def find(self, nums: List[int], target: int, first: bool) -> int:
        l, r = 0, len(nums) - 1
        idx = -1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] > target:
                r = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                idx = mid
                if first:
                    r = mid - 1
                else:
                    l = mid + 1
        return idx