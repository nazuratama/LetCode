class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minp = 2147483647;
        int maxp = 0;
        
        for (int p : prices) {
            if (p < minp) {
                minp = p;
            } else if (p - minp > maxp) {
                maxp = p - minp;
            }
        }
        return maxp;
    }
};