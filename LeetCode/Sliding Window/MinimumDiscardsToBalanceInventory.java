///  https://leetcode.com/problems/minimum-discards-to-balance-inventory/description/

class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int[] freq = new int[100_002];
        HashSet<Integer> discarded = new HashSet<>();
        int left = 0;

        for(int right = 0; right < arrivals.length; ++right){
            if(right - left + 1 > w) {
                if(!discarded.contains(left)){
                    freq[arrivals[left]]--;
                }
                left++;
            }

            if(freq[arrivals[right]] >= m) {
                discarded.add(right);
            }else{
                freq[arrivals[right]]++;
            }
        } 

        return discarded.size();
    }
}