class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if (matrix.empty()) {
            return {};
        }

        vector<int> res;
        int l = 0, r = matrix[0].size() - 1;
        int t = 0, b = matrix.size() - 1;

        while (l <= r && t <= b) {
            for (int i = l; i <= r; ++i) {
                res.push_back(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= b; ++i) {
                res.push_back(matrix[i][r]);
            }
            r--;

            if (t > b) break;
            
            for (int i = r; i >= l; --i) {
                res.push_back(matrix[b][i]);
            }
            b--;

            if (l > r) break;

            for (int i = b; i >= t; --i) {
                res.push_back(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
};