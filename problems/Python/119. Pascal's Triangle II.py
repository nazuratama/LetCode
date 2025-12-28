class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1]
        val = 1
        for k in range(1, rowIndex + 1):
            val = val * (rowIndex - k + 1) // k
            res.append(val)
        return res