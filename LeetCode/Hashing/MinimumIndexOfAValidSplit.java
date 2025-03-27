/// https://leetcode.com/problems/minimum-index-of-a-valid-split/description/


//T: O(n)        S: O(n)
class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> mp = new HashMap<>(); 
        int n = nums.size();

        int dominant = nums.get(0), rightCount = 1, leftCount = 0;         
        for(Integer num : nums){
            Integer newCount = mp.getOrDefault(num,0) + 1;
            mp.put(num, newCount); 

            if(newCount > rightCount) {
                rightCount = newCount; 
                dominant = num;                 
            }
        }

        for(int i=0; i<n; i++){
            if(nums.get(i) == dominant){
                rightCount--; 
                leftCount++; 

                if(leftCount > (i+1)/2 && rightCount > (n-i-1) / 2) 
                    return i;
            }
        }

        return -1;
    }
}