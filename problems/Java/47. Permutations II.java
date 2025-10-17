class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bt(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void bt(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            bt(res, path, nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}