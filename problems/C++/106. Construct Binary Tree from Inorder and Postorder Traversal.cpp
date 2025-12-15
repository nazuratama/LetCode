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
    int pidx;
    int mp[6001];
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        pidx = postorder.size() - 1;
        for(int i = 0; i < inorder.size(); ++i) {
            mp[inorder[i] + 3000] = i;
        }
        return bld(postorder, 0, inorder.size() - 1);
    }
    
    TreeNode* bld(vector<int>& postorder, int l, int r) {
        if(l > r) return nullptr;
        
        int val = postorder[pidx--];
        TreeNode* node = new TreeNode(val);
        int mid = mp[val + 3000];
        
        node->right = bld(postorder, mid + 1, r);
        node->left = bld(postorder, l, mid - 1);
        return node;
    }
};