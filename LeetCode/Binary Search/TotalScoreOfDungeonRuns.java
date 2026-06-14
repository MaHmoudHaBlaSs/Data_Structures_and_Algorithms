///  https://leetcode.com/problems/total-score-of-dungeon-runs/description/


class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        int[] pref = new int[n+1];
        
        long ans = 0;

        for(int i=0; i<n; ++i){
            pref[i+1] = pref[i] + damage[i];

            ans += score(i, requirement[i], hp, pref);
        }

        return ans;
    }

    private int score(int i, int requirement, int hp, int[] pref){
        int l=0, r=i+1;
        int ans = 0;

        while(l<=r){
            int mid = (l+r) >> 1;

            if(requirement <= hp - (pref[i+1] - pref[mid])){
                ans = i+1 - mid;
                r=mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return ans;
    }
}