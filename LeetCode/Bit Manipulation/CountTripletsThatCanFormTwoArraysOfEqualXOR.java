/// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/


class Solution {
    public int countTriplets(int[] arr) {
        int ans =0;
        for(int j=1; j<arr.length; ++j){
            int leftMask = 0;
            HashMap<Integer, Integer> leftMap = new HashMap<>();

            for(int i=j-1; i>=0; --i){
                leftMask ^= arr[i]; 
                leftMap.put(leftMask, leftMap.getOrDefault(leftMask, 0)+1);
            }

            int rightMask = 0;
            for(int k=j; k<arr.length; ++k){
                rightMask ^= arr[k];
                ans += leftMap.getOrDefault(rightMask, 0);
            }
        }

        return ans; 
    }
}