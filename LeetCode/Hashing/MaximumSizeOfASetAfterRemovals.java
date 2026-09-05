///  https://leetcode.com/problems/maximum-size-of-a-set-after-removals/description/

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> nums2Set = new HashSet<>();
        for(int num : nums1) nums1Set.add(num);
        for(int num : nums2) nums2Set.add(num);
        
        int n = nums1.length/2;
        
        Set<Integer> ans = new HashSet<>();
        var unique1 = nums1Set.stream()
                .filter((num) -> !nums2Set.contains(num)).collect(Collectors.toSet());

        if(unique1.size() >= n){
            unique1.stream().limit(n).forEach(ans::add);
        }else{
            ans.addAll(unique1);
            int req = n - ans.size();
            nums1Set.stream().filter(num-> !unique1.contains(num)).limit(req).forEach(ans::add);
        }
        
        var unique2 = nums2Set.stream()
                .filter((num) -> !ans.contains(num))
                .collect(Collectors.toSet());

        if(unique2.size() >= n){
            unique2.stream().limit(n).forEach(ans::add);
        }else{
            ans.addAll(unique2);
        }

        return Integer.min(nums1.length, ans.size());
    }
}