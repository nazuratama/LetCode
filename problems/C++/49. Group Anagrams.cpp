class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        
        for (const string& s : strs) {
            string key = s;
            sort(key.begin(), key.end());
            map[key].push_back(s);
        }
        
        vector<vector<string>> res;
        for (auto const& pair : map) {
            res.push_back(pair.second);
        }
        
        return res;
    }
};