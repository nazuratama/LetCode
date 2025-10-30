class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            nums.add(i);
        }

        StringBuilder res = new StringBuilder();
        k--;

        for (int i = n; i > 0; i--) {
            int idx = k / fact[i - 1];
            k %= fact[i - 1];
            res.append(nums.remove(idx));
        }

        return res.toString();
    }
}