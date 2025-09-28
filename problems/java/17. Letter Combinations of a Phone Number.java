class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Character, String> dmap = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        
        LinkedList<String> q = new LinkedList<>();
        q.add("");

        for (char d : digits.toCharArray()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String path = q.poll();
                String ltrs = dmap.get(d);
                for (char c : ltrs.toCharArray()) {
                    q.add(path + c);
                }
            }
        }
        return q;
    }
}