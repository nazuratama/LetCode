class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates, target, new ArrayList<>(), 0, res);
        return res;
    }

    private void bt(int[] candidates, int rem, List<Integer> path, int start, List<List<Integer>> res) {
        if (rem == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (rem < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            bt(candidates, rem - candidates[i], path, i, res);
            path.remove(path.size() - 1);
        }
    }
}
