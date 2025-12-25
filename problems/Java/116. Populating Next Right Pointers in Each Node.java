/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node l = root;
        while (l.left != null) {
            Node h = l;
            while (h != null) {
                h.left.next = h.right;
                if (h.next != null) {
                    h.right.next = h.next.left;
                }
                h = h.next;
            }
            l = l.left;
        }
        return root;
    }
}