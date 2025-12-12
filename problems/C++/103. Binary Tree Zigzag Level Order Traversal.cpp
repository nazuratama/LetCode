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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (!root) return res;
        
        queue<TreeNode*> q;
        q.push(root);
        bool ldr = true;
        
        while (!q.empty()) {
            int sz = q.size();
            vector<int> row(sz);
            
            for (int i = 0; i < sz; ++i) {
                TreeNode* cur = q.front();
                q.pop();
                
                int idx = ldr ? i : (sz - 1 - i);
                row[idx] = cur->val;
                
                if (cur->left) q.push(cur->left);
                if (cur->right) q.push(cur->right);
            }
            res.push_back(row);
            ldr = !ldr;
        }
        return res;
    }
};