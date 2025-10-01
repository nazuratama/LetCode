class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        dmap = {
            "2":"abc", 
            "3":"def", 
            "4":"ghi", 
            "5":"jkl", 
            "6":"mno", 
            "7":"pqrs", 
            "8":"tuv", 
            "9":"wxyz"}
        
        q = [""]

        for d in digits:
            n = len(q)
            for _ in range(n):
                path = q.pop(0)
                ltrs = dmap[d]
                for c in ltrs:
                    q.append(path + c)
        
        return q