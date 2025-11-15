class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int l = 0, rlen = Integer.MAX_VALUE, ridx = -1;
        int need = tmap.size(), have = 0;
        Map<Character, Integer> wmap = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            wmap.put(c, wmap.getOrDefault(c, 0) + 1);

            if (tmap.containsKey(c) && wmap.get(c).equals(tmap.get(c))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 < rlen) {
                    rlen = r - l + 1;
                    ridx = l;
                }
                char lc = s.charAt(l);
                wmap.put(lc, wmap.get(lc) - 1);
                if (tmap.containsKey(lc) && wmap.get(lc) < tmap.get(lc)) {
                    have--;
                }
                l++;
            }
        }
        return (rlen == Integer.MAX_VALUE) ? "" : s.substring(ridx, ridx + rlen);
    }
}