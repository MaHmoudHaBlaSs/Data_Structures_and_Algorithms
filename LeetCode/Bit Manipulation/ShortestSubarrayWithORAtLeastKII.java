/// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, left = 0;
        int[] freq = new int[32];

        for(int right=0; right<nums.length; ++right){
            int mask = 0;

            for(int i=0; i<32; ++i){
                if((nums[right] & (1<<i)) != 0){
                    freq[i]++;
                }

                if(freq[i] > 0) mask |= (1<<i);
            }


            while(left < right && mask >= k){
                int next = 0;
                int[] nextFreq = new int[32];

                for(int i=0; i<32; ++i){
                    if((nums[left] & (1<<i)) != 0){
                        nextFreq[i] = freq[i]-1;
                    }else {
                        nextFreq[i] = freq[i]; 
                    }

                    if(nextFreq[i] > 0) next |= (1<<i);
                }

                if(next < k) break;

                mask = next;
                left++;
                freq = nextFreq;
            }


            if(mask >= k) ans = Integer.min(ans, right-left+1);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}