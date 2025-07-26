/// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String pref = folder[0] + "/";
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        
        for (int i = 1; i < folder.length; i++) {
            if(!folder[i].startsWith(pref)) {
                ans.add(folder[i]);
                pref = folder[i]+"/";
            }
        }
        
        return ans;
    }
}