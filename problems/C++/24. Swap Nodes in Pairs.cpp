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
    ListNode* swapPairs(ListNode* head) {
        ListNode* dumm = new ListNode(0, head);
        ListNode* prev = dumm;

        while (prev->next && prev->next->next) {
            ListNode* n1 = prev->next;
            ListNode* n2 = n1->next;

            prev->next = n2;
            n1->next = n2->next;
            n2->next = n1;

            prev = n1;
        }
        return dumm->next;
    }
};