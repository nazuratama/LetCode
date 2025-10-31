struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || !head->next || k == 0) {
            return head;
        }

        int n = 1;
        ListNode* tail = head;
        while (tail->next) {
            tail = tail->next;
            n++;
        }
        
        tail->next = head;

        k %= n;
        int steps = n - k;
        
        ListNode* new_tail = tail;
        for (int i = 0; i < steps; ++i) {
            new_tail = new_tail->next;
        }
        
        ListNode* new_head = new_tail->next;
        new_tail->next = nullptr;

        return new_head;
    }
};