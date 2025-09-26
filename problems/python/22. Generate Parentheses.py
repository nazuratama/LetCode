class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def bt(op, cl, path):
            if len(path) == n * 2:
                res.append(path)
                return

            if op < n:
                bt(op + 1, cl, path + "(")
            
            if cl < op:
                bt(op, cl + 1, path + ")")

        bt(0, 0, "")
        return res