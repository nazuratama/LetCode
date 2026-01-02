/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int mx = INT_MIN;

    int maxPathSum(TreeNode* root) {
        dfs(root);
        return mx;
    }

    int dfs(TreeNode* n) {
        if (!n) return 0;

        int l = max(0, dfs(n->left));
        int r = max(0, dfs(n->right));

        mx = max(mx, n->val + l + r);

        return n->val + max(l, r);
    }
};