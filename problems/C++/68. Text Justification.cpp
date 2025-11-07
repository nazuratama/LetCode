class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxw) {
        vector<string> res;
        int i = 0, n = words.size();

        while (i < n) {
            int j = i, llen = 0;
            while (j < n && llen + words[j].length() + (j - i) <= maxw) {
                llen += words[j].length();
                j++;
            }

            string row = "";
            int gaps = j - i - 1;
            
            if (j == n || gaps == 0) { // Last line or single word
                for (int k = i; k < j; ++k) {
                    row += words[k];
                    if (k < j - 1) row += " ";
                }
                row.append(maxw - row.length(), ' ');
            } else { // Normal justification
                int spcs = (maxw - llen) / gaps;
                int xtra = (maxw - llen) % gaps;
                for (int k = i; k < j - 1; ++k) {
                    row += words[k];
                    row.append(spcs, ' ');
                    if (xtra > 0) {
                        row += ' ';
                        xtra--;
                    }
                }
                row += words[j - 1];
            }
            res.push_back(row);
            i = j;
        }
        return res;
    }
};