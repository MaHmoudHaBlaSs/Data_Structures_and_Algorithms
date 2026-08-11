///  https://leetcode.com/problems/find-all-good-indices/description/

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> left = new ArrayDeque<>(), right = new ArrayDeque<>();
        int l = 0, r = k+1;
        
        for(int i=k; i<nums.length-k; ++i){
            if(!left.isEmpty() && left.peekFirst() < i-k) left.removeFirst();
            if(!right.isEmpty() && right.peekFirst() <= i) right.removeFirst();

            while(l < i){
                if(left.isEmpty() || nums[l] <= nums[left.peekLast()]){
                    left.addLast(l);
                }else{
                    left.clear();
                    left.addLast(l);
                }

                l++;
            }

            while(r <= i+k){
                if(right.isEmpty() || nums[r] >= nums[right.peekLast()]){
                    right.addLast(r);
                }else{
                    right.clear();
                    right.addLast(r);
                }

                r++;
            }    

            if(left.size() == k && right.size() == k) list.add(i);        
        }

        return list;
    }   
}