class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        vector<string> res(numRows);
        int row = 0;
        bool down = false;

        for (char c : s) {
            res[row] += c;
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }
        
        string finalRes = "";
        
        for (const string& str : res) {
            finalRes += str;
        }
        return finalRes;
    }
};