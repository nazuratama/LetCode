class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int i = mid, j = mid;
                while (i > 0 && nums[i - 1] == target) i--;
                while (j < nums.length - 1 && nums[j + 1] == target) j++;
                return new int[]{i, j};
            }
            
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
