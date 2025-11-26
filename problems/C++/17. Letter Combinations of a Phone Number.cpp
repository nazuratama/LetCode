class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) {
            return {};
        }

        unordered_map<char, string> dmap = {
            {'2', "abc"}, 
            {'3', "def"}, 
            {'4', "ghi"}, 
            {'5', "jkl"},
            {'6', "mno"}, 
            {'7', "pqrs"}, 
            {'8', "tuv"}, 
            {'9', "wxyz"}
        };

        vector<string> res;
        res.push_back("");

        for (char d : digits) {
            vector<string> temp;
            for (const string& path : res) {
                for (char c : dmap[d]) {
                    temp.push_back(path + c);
                }
            }
            res = temp;
        }
        return res;
    }
};
