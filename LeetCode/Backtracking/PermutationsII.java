///   https://leetcode.com/problems/permutations-ii/

//The same as usual but to get unique ones, don't take the same digit in the same position twice

class Solution {
    private boolean[] visited ; 
    private List<List<Integer>> ans; 
    private List<Integer> list;
    private int[] nums; 
    private int n;

    private void solve(int i){
        if(i >= n){
            ans.add(new ArrayList<>(list)); 
            return;
        }

        HashSet<Integer> usedInI = new HashSet<>();

        for(int j=0;j<n; j++){
            if(!visited[j] && !usedInI.contains(nums[j])){
                usedInI.add(nums[j]);

                visited[j] = true; 
                list.add(nums[j]);

                solve(i+1); 
                
                list.removeLast(); 
                visited[j] = false; 
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        this.nums = nums; 
        n = nums.length; 
        visited=  new boolean[n];
        solve(0); 

        return ans;
    }
}