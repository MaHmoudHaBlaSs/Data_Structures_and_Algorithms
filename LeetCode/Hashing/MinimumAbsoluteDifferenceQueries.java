///  https://leetcode.com/problems/minimum-absolute-difference-queries/description/


class Solution {
    private final int oo = 0x3f3f3f3f;

    public int[] minDifference(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) 
            mp.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
        
        for(int i=0; i<ans.length; i++){
            int[] query = queries[i];
            ArrayList<Integer> inRange = new ArrayList<>();
            int minDiff = oo;
            
            for(int j=1; j<= 100; j++){
                if(doesExist(mp, query[0], query[1], j)){
                    if(!inRange.isEmpty())
                        minDiff = Math.min(minDiff, j - inRange.getLast());
                    
                    inRange.add(j);
                }
            }       
            
            ans[i] = minDiff == oo ? -1 : minDiff; 
        }

        return ans;
    }

    private boolean doesExist(Map<Integer, List<Integer>> mp ,int l, int r, int x) {
        if (!mp.containsKey(x)) return false;
        
        List<Integer> positions = mp.get(x);
        int left = 0, right = positions.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
        
            if (positions.get(mid) < l) left = mid + 1;
            else if (positions.get(mid) > r) right = mid - 1;
            else return true;
        }

        return false;
    }
}