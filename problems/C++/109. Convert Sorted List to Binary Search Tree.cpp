/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
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
    ListNode* curr;
public:
    TreeNode* sortedListToBST(ListNode* head) {
        int n = 0;
        ListNode* temp = head;
        while(temp) {
            n++;
            temp = temp->next;
        }
        
        curr = head;
        return bld(0, n - 1);
    }
    
    TreeNode* bld(int l, int r) {
        if (l > r) return nullptr;
        
        int mid = l + (r - l) / 2;
        
        TreeNode* left = bld(l, mid - 1);
        
        TreeNode* node = new TreeNode(curr->val);
        node->left = left;
        curr = curr->next;
        
        node->right = bld(mid + 1, r);
        
        return node;
    }
};

