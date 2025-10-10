class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int targ) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<>();
        bt(cand, targ, new ArrayList<>(), 0, res);
        return res;
    }

    private void bt(int[] cand, int rem, List<Integer> path, int start, List<List<Integer>> res) {
        if (rem == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (rem < 0) {
            return;
        }

        for (int i = start; i < cand.length; i++) {
            if (i > start && cand[i] == cand[i-1]) {
                continue;
            }
            path.add(cand[i]);
            bt(cand, rem - cand[i], path, i + 1, res);
            path.remove(path.size() - 1);
        }
    }
}