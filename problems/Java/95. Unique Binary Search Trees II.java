class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return gen(1, n);
    }

    private List<TreeNode> gen(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = gen(start, i - 1);
            List<TreeNode> rights = gen(i + 1, end);
            for (TreeNode l_node : lefts) {
                for (TreeNode r_node : rights) {
                    TreeNode root = new TreeNode(i, l_node, r_node);
                    res.add(root);
                }
            }
        }
        return res;
    }
}