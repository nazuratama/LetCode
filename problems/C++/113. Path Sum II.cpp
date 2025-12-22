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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        vector<int> pth;
        dfs(root, targetSum, pth, res);
        return res;
    }

    void dfs(TreeNode* n, int rem, vector<int>& pth, vector<vector<int>>& res) {
        if (!n) return;

        pth.push_back(n->val);

        if (!n->left && !n->right && n->val == rem) {
            res.push_back(pth);
        } else {
            dfs(n->left, rem - n->val, pth, res);
            dfs(n->right, rem - n->val, pth, res);
        }

        pth.pop_back();
    }
};