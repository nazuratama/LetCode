class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.empty()) return 0;
        int n = matrix[0].size();
        vector<int> h(n, 0);
        int area = 0;

        for (int r = 0; r < matrix.size(); ++r) {
            for (int c = 0; c < n; ++c) {
                h[c] = (matrix[r][c] == '1') ? h[c] + 1 : 0;
            }
            area = max(area, lrh(h));
        }
        return area;
    }

private:
    int lrh(const vector<int>& heights) {
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