class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        Map<Character, Character> cmap = Map.of(')', '(', '}', '{', ']', '[');
        
        for (char c : s.toCharArray()) {
            if (cmap.containsKey(c)) {
                if (stk.isEmpty() || stk.pop() != cmap.get(c)) {
                    return false;
                }
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}