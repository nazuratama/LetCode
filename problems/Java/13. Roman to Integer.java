class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> rmap = new HashMap<>();
        rmap.put('I', 1);
        rmap.put('V', 5);
        rmap.put('X', 10);
        rmap.put('L', 50);
        rmap.put('C', 100);
        rmap.put('D', 500);
        rmap.put('M', 1000);
        
        int res = 0;
        int prev = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = rmap.get(s.charAt(i));
            if (val < prev) {
                res -= val;
            } else {
                res += val;
            }
            prev = val;
        }
        return res;
    }
}