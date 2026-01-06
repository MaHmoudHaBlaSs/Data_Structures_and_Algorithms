/// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n =  adjacentPairs.length+1;
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>(n);

        for(int[] pair : adjacentPairs){
            mp.putIfAbsent(pair[0], new ArrayList<>(2));
            mp.putIfAbsent(pair[1], new ArrayList<>(2));

            var l1 = mp.get(pair[0]);
            var l2 = mp.get(pair[1]);

            l1.add(pair[1]);
            l2.add(pair[0]);
        }
        
        int start = 0;
        for (var entry : mp.entrySet()){
            if(entry.getValue().size() == 1) start = entry.getKey();
        }
        
        int[] nums = new int[n];
        nums[0] = start;
        int p = 0x3f3f3f3f;

        for (int i = 1; i < n; i++) {
            var l = mp.get(nums[i-1]);

            if(l.getFirst() != p) nums[i] = l.getFirst();
            else nums[i] = l.getLast();

            p = nums[i-1];
        }

        return nums;
    }
}