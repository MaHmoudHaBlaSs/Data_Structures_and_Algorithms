///  https://leetcode.com/problems/friends-of-appropriate-ages/


// Time: O(n)          Space: O(1)
class Solution {
    public int numFriendRequests(int[] ages) {
        int ans = 0;
        int[] ferq = new int[121];
        
        for(int age: ages)
            ferq[age]++;

        for(int i=0; i<121; i++){
            for(int j=0; j <= i; j++){
                if(request(i, j)){
                    ans += ferq[i] * ferq[j];
                    if(i==j)
                        ans -= ferq[i];
                }
            }
        }
        return ans;
    }

    private boolean request(int a, int b){
        return !(b<=0.5*a+7 || b>a || (b>100 && a<100));
    }
}