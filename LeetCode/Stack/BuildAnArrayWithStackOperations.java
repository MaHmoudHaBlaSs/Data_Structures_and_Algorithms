///  https://leetcode.com/problems/build-an-array-with-stack-operations/description/


class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>(); 
        int stream = 1, i =0, len = target.length;

        while(stream <= n && i < len){
            ans.add("Push");
            if(target[i] == stream){
                ++i;
            }else {
                ans.add("Pop");
            }
            ++stream;
        }

        return ans;
    }
}