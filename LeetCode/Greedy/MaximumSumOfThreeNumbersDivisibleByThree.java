///  https://leetcode.com/problems/maximum-sum-of-three-numbers-divisible-by-three/description/

class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer>[] arr = new ArrayList[3];
        for(int i=0; i<3; ++i) arr[i] = new ArrayList<>();

        for(int num : nums){
            arr[(num+3) % 3].add(num); 
        }

        int ans = 0, max3 = 0; 
        for(int i=0; i<3; ++i){ 
            var curr = arr[i];
            int size = curr.size(); 
            
            if(size > 2){
                ans = Integer.max(ans, curr.get(size-1)+curr.get(size-2)+curr.get(size-3));
            }

            if(size > 0 && max3 >= 0) max3 += curr.get(size-1);
            else max3 = -1;
        }

        return Integer.max(ans, max3);
    }
}