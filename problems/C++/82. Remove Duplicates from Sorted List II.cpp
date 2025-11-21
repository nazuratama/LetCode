struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* dumm = new ListNode(0, head);
        ListNode* prev = dumm;

        while (prev->next && prev->next->next) {
            if (prev->next->val == prev->next->next->val) {
                int dup_val = prev->next->val;
                while (prev->next && prev->next->val == dup_val) {
                    prev->next = prev->next->next;
                }
            } else {
                prev = prev->next;
            }
        }
        return dumm->next;
    }
};