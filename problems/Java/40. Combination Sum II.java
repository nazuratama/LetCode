class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            bt(candidates, rem - candidates[i], path, i + 1, res);
            path.remove(path.size() - 1);
        }
    }
}