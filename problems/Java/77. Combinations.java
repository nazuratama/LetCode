class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        bt(1, new ArrayList<>(), res, n, k);
        return res;
    }

    private void bt(int start, List<Integer> path, List<List<Integer>> res, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            bt(i + 1, path, res, n, k);
            path.remove(path.size() - 1);
        }
    }
}