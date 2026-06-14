///  https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/description/

class Solution {
    public int minOperations(int[] nums) {
        int distinct = 0, n = nums.length; 
        int[] freq = new int[1_000_03]; 

        for(int num : nums){
            if(freq[num] == 0) distinct++;

            freq[num]++;
        }

        int operations = 0, j = 0;
        
        while(j < n){
            if(distinct == n-j) return operations;

            for(int i=0; j+i<n && i<3; ++i){
                if(freq[nums[i+j]] == 1) distinct--;

                freq[nums[i+j]]--;    
            }

            j += 3;
            operations++;
        }

        return operations;
    }
}