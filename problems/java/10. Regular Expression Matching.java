class Solution {
    private String s, p;
    private Map<String, Boolean> cache;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.cache = new HashMap<>();
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        String key = i + "," + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (j == p.length()) {
            return i == s.length();
        }

        boolean m = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        boolean res;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            res = dfs(i, j + 2) || (m && dfs(i + 1, j));
        } else if (m) {
            res = dfs(i + 1, j + 1);
        } else {
            res = false;
        }

        cache.put(key, res);
        return res;
    }
}