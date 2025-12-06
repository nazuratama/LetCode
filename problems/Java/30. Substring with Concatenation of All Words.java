class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) return new ArrayList<>();
        
        int wlen = words[0].length();
        int n = words.length;
        int tlen = wlen * n;
        
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wmap = new HashMap<>();

        for (String w : words) {
            wmap.put(w, wmap.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wlen; i++) {
            Map<String, Integer> smap = new HashMap<>();
            int l = i;
            int cnt = 0;

            for (int r = i; r <= s.length() - wlen; r += wlen) {
                String word = s.substring(r, r + wlen);
                if (wmap.containsKey(word)) {
                    smap.put(word, smap.getOrDefault(word, 0) + 1);
                    cnt++;
                    while (smap.get(word) > wmap.get(word)) {
                        String lword = s.substring(l, l + wlen);
                        smap.put(lword, smap.get(lword) - 1);
                        cnt--;
                        l += wlen;
                    }
                    if (cnt == n) {
                        res.add(l);
                    }
                } else {
                    smap.clear();
                    cnt = 0;
                    l = r + wlen;
                }
            }
        }
        return res;
    }
}