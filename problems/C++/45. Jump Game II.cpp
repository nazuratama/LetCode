class Solution {
public:
    int jump(vector<int>& nums) {
        int jmp = 0;
        int end = 0;
        int far = 0;

        for (int i = 0; i < nums.size() - 1; ++i) {
            far = max(far, i + nums[i]);

            if (i == end) {
                jmp++;
                end = far;
            }
        }
        return jmp;
    }
};
