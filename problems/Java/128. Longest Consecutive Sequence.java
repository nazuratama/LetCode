class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);
        
        int mx = 0;
        for (int n : s) {
            if (!s.contains(n - 1)) {
                int cur = n;
                int l = 1;
                while (s.contains(cur + 1)) {
                    cur++;
                    l++;
                }
                if (l > mx) mx = l;
            }
        }
        return mx;
    }
}