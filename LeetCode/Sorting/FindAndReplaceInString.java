///  https://leetcode.com/problems/find-and-replace-in-string/description/

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<indices.length; ++i){
            boolean isMatch = (s.length() - indices[i]) >= sources[i].length();

            for(int j=0; j<sources[i].length() && isMatch; ++j){
                if(s.charAt(indices[i] + j) != sources[i].charAt(j))
                    isMatch = false;
            }

            if(isMatch) list.add(i);
        }

        list.sort((a,b) -> Integer.compare(indices[a], indices[b]));

        StringBuilder ans = new StringBuilder();
        int sIdx = 0, listIdx = 0;

        while(sIdx < s.length()){

            if(listIdx < list.size() && sIdx == indices[list.get(listIdx)]){
                sIdx += sources[list.get(listIdx)].length();

                ans.append(targets[list.get(listIdx)]);
                listIdx++;
            }
            else{
                ans.append(s.charAt(sIdx));
                sIdx++;
            }
        }
        
        return ans.toString();
    }
}