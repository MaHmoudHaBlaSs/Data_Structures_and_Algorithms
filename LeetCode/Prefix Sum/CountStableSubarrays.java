///  https://leetcode.com/problems/count-stable-subarrays/description/


class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] q) {
        int n = nums.length;
        long[] pref = new long[n];
        long prev = 0;

        ArrayList<Integer> segments = new ArrayList<>();

        for(int i=0; i<nums.length; ++i){
            int j = i; 
            pref[j] = prev + 1;

            while(j+1 < n && nums[j+1] >= nums[j]){
                j++;  
                pref[j] = pref[j-1] + (j-i+1);
            }

            prev = pref[j];
            i = j;
            segments.add(j);
        }

        long[] ans = new long[q.length];
        for(int i=0; i<q.length; ++i){
            int l = q[i][0], r = q[i][1];

            int j = minLargerOrEqual(segments, l);
            j = Math.min(j,r);

            long len = j-l+1;

            long sum = pref[r] - pref[j];
            sum += len * (len+1) >> 1;

            ans[i] = sum;
        }

        return ans;
    }

    private int minLargerOrEqual(List<Integer> list, int key){
        int l = 0, r = list.size()-1, ans = -1;

        while(l<=r){
            int mid = (l+r) >> 1;

            if(list.get(mid) >= key){
                ans = mid;
                r = mid - 1;
            }else 
                l = mid+1;
        }

        return list.get(ans);
    }
}