/// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/

class Solution {
    public int numSteps(String s) {
        boolean[] one = new boolean[s.length()];

        for(int i=0; i<one.length; ++i){
            one[i] = s.charAt(i) == '1';
        }

        return steps(one.length-1, one);
    }

    private int steps(int i, boolean[] one){
        if(i<=0) return 0;

        if(!one[i]) return 1 + steps(i-1, one);

        int zeroIdx = i;
        while(zeroIdx >= 0 && one[zeroIdx]) --zeroIdx;

        if(zeroIdx >= 0){
            one[zeroIdx] = true;
        } 

        return i-zeroIdx+1 + steps(zeroIdx, one);
    }
}