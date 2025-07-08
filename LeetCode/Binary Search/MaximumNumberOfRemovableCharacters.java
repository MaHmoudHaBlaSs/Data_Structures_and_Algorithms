///  https://leetcode.com/problems/maximum-number-of-removable-characters/description/

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length ,left = 0, right = n, k = 0;

        while(left <= right){
            int mid = (left+right) / 2;
            
            if(isSubsequence(s,p,mid,removable)){
                k = mid; 
                left = mid+1;
            }
            else right = mid-1;
        }
        
        return k;
    }

    private boolean isSubsequence(String s,String p,int k, int[] removable){
        boolean[] removed = new boolean[s.length()];

        for (int i = 0; i < k; i++)
            removed[removable[i]] = true;

        int sPointer = 0, pPointer = 0;
        while (sPointer < s.length() && pPointer < p.length()){
            if(!removed[sPointer] && s.charAt(sPointer) == p.charAt(pPointer))
                pPointer++;

            sPointer++;
        }

        return pPointer == p.length();
    }
}