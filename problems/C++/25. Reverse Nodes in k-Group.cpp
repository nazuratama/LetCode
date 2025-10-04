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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (k == 1) return head;

        ListNode* dumm = new ListNode(0, head);
        ListNode* gprv = dumm;

        while (true) {
            ListNode* kth = gprv;
            for (int i = 0; i < k; ++i) {
                kth = kth->next;
                if (!kth) return dumm->next;
            }

            ListNode* gnxt = kth->next;
            ListNode* prev = gnxt;
            ListNode* curr = gprv->next;

            while (curr != gnxt) {
                ListNode* temp = curr->next;
                curr->next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode* temp = gprv->next;
            gprv->next = kth;
            gprv = temp;
        }
    }
};