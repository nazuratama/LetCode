class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        bt(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void bt(String s, int start, List<String> path, List<String> res) {
        if (path.size() == 4 && start == s.length()) {
            res.add(String.join(".", path));
            return;
        }
        if (path.size() >= 4 || start >= s.length()) {
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(sub) <= 255) {
                path.add(sub);
                bt(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}