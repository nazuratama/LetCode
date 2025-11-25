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
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* lh = new ListNode(0);
        ListNode* lt = lh;
        ListNode* gh = new ListNode(0);
        ListNode* gt = gh;

        ListNode* curr = head;
        while (curr) {
            if (curr->val < x) {
                lt->next = curr;
                lt = lt->next;
            } else {
                gt->next = curr;
                gt = gt->next;
            }
            curr = curr->next;
        }

        gt->next = nullptr;
        lt->next = gh->next;

        return lh->next;
    }
};