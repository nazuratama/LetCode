class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        String[] comps = path.split("/");

        for (String comp : comps) {
            if (comp.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else if (!comp.isEmpty() && !comp.equals(".")) {
                stk.push(comp);
            }
        }

        if (stk.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty()){
            res.insert(0, stk.pop()).insert(0, "/");
        }
        return res.toString();
    }
}
