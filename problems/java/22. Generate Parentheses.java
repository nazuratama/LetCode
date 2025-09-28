class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bt(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void bt(int n, int op, int cl, StringBuilder path, List<String> res) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }

        if (op < n) {
            path.append("(");
            bt(n, op + 1, cl, path, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (cl < op) {
            path.append(")");
            bt(n, op, cl + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}