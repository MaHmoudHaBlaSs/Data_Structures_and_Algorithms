///  https://leetcode.com/problems/append-k-integers-with-minimal-sum/description/

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        List<Integer> arr = set.stream().sorted().toList();
        int n = arr.size();
        
        long ans = ((long) k * (k+1)) >> 1;
        int next = k + 1, idx = 0;

        while(idx < n && arr.get(idx) <= k){
            ans -= arr.get(idx);
            
            while(set.contains(next)) next++;
            
            ans += next;
            next++;
            idx++;
        }
        
        return ans;
    }
}