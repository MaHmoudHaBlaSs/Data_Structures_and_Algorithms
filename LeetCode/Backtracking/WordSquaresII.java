///  https://leetcode.com/problems/word-squares-ii/description/

class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private String[] words; 

    private void bactrack(int i, List<String> list, int mask){
        if(i==4){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j=0; j<words.length; ++j){
            if((mask & (1<<j)) == 0){
                boolean valid = i==0;
                valid = valid || (i==1 && list.get(0).charAt(0) == words[j].charAt(0));
                valid = valid || (i==2 && list.get(0).charAt(3) == words[j].charAt(0));
                valid = valid || (i==3 && list.get(1).charAt(3) == words[j].charAt(0) && list.get(2).charAt(3) == words[j].charAt(3));

                if(valid){
                    list.add(words[j]);
                    bactrack(i+1, list, mask ^ (1<<j));
                    list.removeLast();                     
                }
            }

        }        
    }

    public List<List<String>> wordSquares(String[] words) {
        this.words = words; 
        Arrays.sort(words); 

        bactrack(0, new ArrayList<>(4), 0);

        return ans;
    }
}