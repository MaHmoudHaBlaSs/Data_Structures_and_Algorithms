/// https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/description/

class Solution {
    public boolean splitString(String s) {
        return can(s,s.length()-1, -1, 0);
    }

    private boolean can(String s,int idx, long prev, int substrings){
        if(idx < 0) return substrings > 1; 

        for(int i=idx; i>=0; --i){
            try{
                long curr = Long.parseLong(s.substring(i,idx+1));
                if(prev != -1){
                    if(curr == prev+1 && can(s,i-1, curr, 1+substrings))
                        return true; 
                }
                else if(can(s,i-1,curr, substrings+1)) 
                    return true;                  
            }catch(Exception e){
                return false;
            }
        }

        return false;
    }
}