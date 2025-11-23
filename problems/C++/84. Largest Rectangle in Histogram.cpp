class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<pair<int, int>> stk;
        int area = 0;
        
        for (int i = 0; i < heights.size(); ++i) {
            int start = i;
            while (!stk.empty() && stk.top().second > heights[i]) {
                pair<int, int> bar = stk.top();
                stk.pop();
                area = max(area, bar.second * (i - bar.first));
                start = bar.first;
            }
            stk.push({start, heights[i]});
        }
        
        while (!stk.empty()) {
            pair<int, int> bar = stk.top();
            stk.pop();
            area = max(area, bar.second * ((int)heights.size() - bar.first));
        }
        
        return area;
    }
};