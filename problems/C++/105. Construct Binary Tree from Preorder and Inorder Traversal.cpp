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
    int pidx = 0;
    int mp[6001];
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); ++i) {
            mp[inorder[i] + 3000] = i;
        }
        return bld(preorder, 0, inorder.size() - 1);
    }
    
    TreeNode* bld(vector<int>& preorder, int l, int r) {
        if(l > r) return nullptr;
        
        int val = preorder[pidx++];
        TreeNode* node = new TreeNode(val);
        int mid = mp[val + 3000];
        
        node->left = bld(preorder, l, mid - 1);
        node->right = bld(preorder, mid + 1, r);
        return node;
    }
};