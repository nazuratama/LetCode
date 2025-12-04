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
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return {};
        return gen(1, n);
    }

private:
    vector<TreeNode*> gen(int start, int end) {
        vector<TreeNode*> res;
        if (start > end) {
            res.push_back(nullptr);
            return res;
        }

        for (int i = start; i <= end; ++i) {
            vector<TreeNode*> lefts = gen(start, i - 1);
            vector<TreeNode*> rights = gen(i + 1, end);
            for (TreeNode* l_node : lefts) {
                for (TreeNode* r_node : rights) {
                    TreeNode* root = new TreeNode(i, l_node, r_node);
                    res.push_back(root);
                }
            }
        }
        return res;
    }
};