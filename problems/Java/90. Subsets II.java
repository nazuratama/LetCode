class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        bt(0, new ArrayList<>(), nums, res);

        return res;

    }

    private void bt(int start, List<Integer> path, int[] nums, List<List<Integer>> res) {

        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i-1]) {

                continue;

            }

            path.add(nums[i]);

            bt(i + 1, path, nums, res);

            path.remove(path.size() - 1);

        }

    }

}