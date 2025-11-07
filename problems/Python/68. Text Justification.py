class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res, line, llen = [], [], 0
        i = 0
        while i < len(words):
            if llen + len(line) + len(words[i]) > maxWidth:
                gaps = len(line) - 1
                if gaps == 0:
                    res.append(line[0] + ' ' * (maxWidth - llen))
                else:
                    spcs = (maxWidth - llen) // gaps
                    xtra = (maxWidth - llen) % gaps
                    row = ""
                    for k in range(gaps):
                        row += line[k] + ' ' * spcs
                        if xtra > 0:
                            row += ' '
                            xtra -= 1
                    row += line[-1]
                    res.append(row)
                line, llen = [], 0
            
            line.append(words[i])
            llen += len(words[i])
            i += 1
            
        last = " ".join(line)
        res.append(last + ' ' * (maxWidth - len(last)))
        return res