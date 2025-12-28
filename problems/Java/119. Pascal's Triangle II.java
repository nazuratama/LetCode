class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long val = 1;
        for (int k = 1; k <= rowIndex; k++) {
            val = val * (rowIndex - k + 1) / k;
            res.add((int) val);
        }
        return res;
    }
}