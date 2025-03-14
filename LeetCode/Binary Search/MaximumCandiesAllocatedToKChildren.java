/// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/

//Time: O(N.log(M))           Space: O(1)
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int ans = 0, left = 1, right = 0; 
        
        for(int candy : candies)
            if(candy>right) 
                right = candy;
        

        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(candies, mid, k)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] candies, int childCandies, long k){
        long count = 0;
        for(int candy : candies)
        {
            count += (candy/childCandies);

            if(count>=k) 
                return true;
        }
        
        return count >= k;
    }

}