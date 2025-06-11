///   https://leetcode.com/problems/arithmetic-subarrays/description/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>(l.length);
        
        for(int i=0; i<l.length; i++){
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i]+1);
            Arrays.sort(sub);
            
            int diff = sub[1] - sub[0];
            boolean flag = true;
            
            for (int j = 2; j < sub.length; j++) {
                if(sub[j] - sub[j-1] == diff) continue;
                flag = false;
                break;
            }
            
            result.add(flag);
        }
        
        return result;
    }
}