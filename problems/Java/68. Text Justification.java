class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;
        
        while (i < n) {
            List<String> line = new ArrayList<>();
            int llen = 0;
            int j = i;
            while (j < n && llen + words[j].length() + line.size() <= maxWidth) {
                line.add(words[j]);
                llen += words[j].length();
                j++;
            }

            StringBuilder row = new StringBuilder();
            int gaps = line.size() - 1;

            if (j == n || gaps == 0) { // Last line or single word
                for(int k=0; k < line.size(); k++) {
                    row.append(line.get(k));
                    if (k < line.size() - 1) row.append(" ");
                }
                while (row.length() < maxWidth) row.append(" ");
            } else { // Normal justification
                int spcs = (maxWidth - llen) / gaps;
                int xtra = (maxWidth - llen) % gaps;
                for (int k = 0; k < line.size() - 1; k++) {
                    row.append(line.get(k));
                    for (int s = 0; s < spcs; s++) row.append(" ");
                    if (xtra > 0) {
                        row.append(" ");
                        xtra--;
                    }
                }
                row.append(line.get(line.size() - 1));
            }
            res.add(row.toString());
            i = j;
        }
        return res;
    }
}