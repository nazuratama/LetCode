class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int l = find(nums, target, true);
        int r = find(nums, target, false);
        return {l, r};
    }

private:
    int find(const vector<int>& nums, int target, bool first) {
        int l = 0, r = nums.size() - 1;
        int idx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                idx = mid;
                if (first) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return idx;
    }
};