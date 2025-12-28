class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> res;
        res.reserve(rowIndex + 1);
        res.push_back(1);
        long long val = 1;
        for (int k = 1; k <= rowIndex; ++k) {
            val = val * (rowIndex - k + 1) / k;
            res.push_back((int)val);
        }
        return res;
    }
};