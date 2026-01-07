# https://leetcode.com/problems/find-duplicate-file-in-system/description/

class Solution:
    # Time: O(n)      Space: O(n)   n >> characters
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        duplicates = {}

        def access_files(files) -> List[List[str]]: 
            res = []
            name_start = 0
            content_start = 0
            
            for i, ch in enumerate(files):
                if ch is '(':
                    content_start = i+1
                    res.append([files[name_start:i]])
                
                elif ch is ')':
                    name_start = i+2
                    res[-1].append(files[content_start:i])
            
            return res

        for folder in paths:
            for i, ch in enumerate(folder):
                if ch is ' ': # file path finished
                    
                    path = folder[:i]
                    files = access_files(folder[i+1:])
                    for f in files: # List(file_name, content)
                        duplicates.setdefault(f[1], []).append(path + '/' + f[0])
                    break

        return [lst for lst in duplicates.values() if len(lst) > 1]