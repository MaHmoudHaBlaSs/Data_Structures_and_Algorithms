/// https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/


class FindSumPairs {
    private HashMap<Integer, Integer> mp = new HashMap<>(); 
    private int[] nums1, nums2; 

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int n : nums2){
            mp.put(n, mp.getOrDefault(n,0) + 1); 
        }
    }
    
    public void add(int index, int val) {
        int old = nums2[index];
        mp.put(old, mp.get(old)-1);
        int newVal =  nums2[index] += val;
        mp.put(newVal, mp.getOrDefault(newVal,0)+1);
    }
    
    public int count(int tot) {
        int ans = 0; 
        for(int num : nums1){
            ans += mp.getOrDefault(tot - num, 0); 
        }
        return ans; 
    }
}