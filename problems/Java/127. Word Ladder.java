class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> d = new HashSet<>(wordList);
        if (!d.contains(endWord)) return 0;
        
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        
        int stp = 1;
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            
            Set<String> nxt = new HashSet<>();
            for (String w : s1) {
                char[] wa = w.toCharArray();
                for (int i = 0; i < wa.length; i++) {
                    char org = wa[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wa[i] = c;
                        String nw = new String(wa);
                        
                        if (s2.contains(nw)) return stp + 1;
                        if (d.contains(nw)) {
                            nxt.add(nw);
                            d.remove(nw);
                        }
                    }
                    wa[i] = org;
                }
            }
            s1 = nxt;
            stp++;
        }
        return 0;
    }
}