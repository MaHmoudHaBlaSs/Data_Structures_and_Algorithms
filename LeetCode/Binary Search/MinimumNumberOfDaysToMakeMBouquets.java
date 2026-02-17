///  https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, h = Arrays.stream(bloomDay).max().getAsInt(); 
        int ans = -1;

        while(l<=h){
            int mid = l + ((h-l) >> 1);

            if(canMake(bloomDay, m,k,mid)){
                ans = mid;
                h=mid-1;
            }else {
                l = mid+1; 
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int maxDays){
        int made = 0, prev = -1; 

        for(int i=0; i<bloomDay.length; ++i){
            if(bloomDay[i] > maxDays){
                made += (i-prev-1) / k;
                prev = i;
            }
        }

        made += (bloomDay.length - prev-1) / k; 

        return made >= m;
    }
}