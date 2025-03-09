///  https://leetcode.com/problems/alternating-groups-ii/description/

//O(n)
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int c = 0, right = 0, n = colors.length; 

        for(int left =0; left<n; left++){

            while(right - left + 1 < k && colors[(right + 1) % n] !=colors[right % n]) 
                right++; 
            
           
            if(right - left + 1 == k){
                c++;  
            } 
            else{ 
                left = right;
                right++; 
            }
        }

        return c;
    }
}