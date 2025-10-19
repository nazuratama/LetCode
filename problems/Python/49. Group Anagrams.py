class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dmap = {}
        
        for s in strs:
            key = "".join(sorted(s))
            if key not in dmap:
                dmap[key] = []
            dmap[key].append(s)
            
        return list(dmap.values())