class Solution {
    public int totalNQueens(int n) {
        return bt(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    
    private int bt(int r, int n, Set<Integer> cols, Set<Integer> pdia, Set<Integer> ndia) {
        if (r == n) {
            return 1;
        }

        int cnt = 0;
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || pdia.contains(r - c) || ndia.contains(r + c)) {
                continue;
            }

            cols.add(c);
            pdia.add(r - c);
            ndia.add(r + c);
            
            cnt += bt(r + 1, n, cols, pdia, ndia);

            cols.remove(c);
            pdia.remove(r - c);
            ndia.remove(r + c);
        }
        return cnt;
    }
}