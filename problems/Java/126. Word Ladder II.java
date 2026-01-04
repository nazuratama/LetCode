class Solution {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> mp = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> d = new HashSet<>(wordList);
        if (!d.contains(endWord)) return res;
        
        Set<String> cur = new HashSet<>();
        cur.add(beginWord);
        boolean fnd = false;

        while (!cur.isEmpty() && !fnd) {
            d.removeAll(cur);
            Set<String> nxt = new HashSet<>();
            
            for (String w : cur) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String nw = new String(chs);
                        if (d.contains(nw)) {
                            if (nw.equals(endWord)) fnd = true;
                            nxt.add(nw);
                            mp.computeIfAbsent(nw, k -> new ArrayList<>()).add(w);
                        }
                    }
                    chs[i] = old;
                }
            }
            cur = nxt;
        }

        if (fnd) {
            List<String> p = new ArrayList<>();
            p.add(endWord);
            dfs(endWord, beginWord, p);
        }
        return res;
    }

    void dfs(String w, String tgt, List<String> p) {
        if (w.equals(tgt)) {
            List<String> tmp = new ArrayList<>(p);
            Collections.reverse(tmp);
            res.add(tmp);
            return;
        }
        if (!mp.containsKey(w)) return;
        for (String par : mp.get(w)) {
            p.add(par);
            dfs(par, tgt, p);
            p.remove(p.size() - 1);
        }
    }
}