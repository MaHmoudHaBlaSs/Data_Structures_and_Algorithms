///  https://leetcode.com/problems/permutations-ii/

// The same as usual but to get unique ones, don't take the same digit in the same position twice

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

// Another Solution by Firstly Sort the Array.
class Solution {
    List<List<Integer>> perms = new LinkedList<>();
    List<Integer> perm = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Essential, could be enhanced as the above code.
        recurse(nums);
        return perms;
    }

    public void recurse(int[] nums){
        if (perm.size() == nums.length){
            perms.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (set.contains(i)) 
                continue;

            // Do
            perm.add(nums[i]);
            set.add(i);
            // Recurse
            recurse(nums);
            // Undo
            perm.removeLast();
            set.remove(i);

            while (i+1 < nums.length && nums[i] == nums[i+1]) // to avoid duplicates.
                i++;
        }
    }

}