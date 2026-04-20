///  https://leetcode.com/problems/sum-of-sortable-integers/description/

// Time: O(n×d(n)) where d(n) is the number of divisors for n
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0;
        List<Integer> divisors = getDivisors(n);

        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                sorted = false;
                break;
            }
        }
        
        for(int k : divisors){
            if(k != 1 && isSortable(k, nums)) ans += k;
        }
        
        if(sorted) ans += 1;
        return ans;
    }

    // O(sqrt(n))
    private List<Integer> getDivisors(int n){
        HashSet<Integer> ans = new HashSet<>();

        for (int i = 1; i*i <= n; i++) {
            if(n % i == 0) {
                ans.add(i);
                ans.add(n/i);
            }
        }

        return new ArrayList<>(ans);
    }
    
    // O(n)
    private boolean isSortable(int k, int[] nums){
        int lastSubarrayMax = 0, subarrays = nums.length/k;

        for (int i = 0; i < subarrays; i++) {
            int start = i*k, end = start+k;

            int minIdx = 0, minNumber = Integer.MAX_VALUE, maxIdx = 0, maxNumber = Integer.MIN_VALUE;
            for (int j = start; j < end; j++) {
                if(nums[j] < minNumber){
                    minIdx = j-start;
                    minNumber = nums[j];
                }
                if(nums[j] >= maxNumber){
                    maxIdx = j-start;
                    maxNumber = nums[j];
                }
            }

            if(minNumber < lastSubarrayMax) return false;

            boolean sortableByLeftRotate = true, sortableByRightRotate = true;
            for (int j = 0; j < k-1; j++) { 
                int currIdx = ((minIdx+j) % k) + start, nextIdx = ((minIdx+j+1) % k) + start;
                int currIdxMax = ((maxIdx-j + k) % k)+start, nextIdxMax = ((maxIdx-j - 1 + k) % k)+start;
                
                if(nums[nextIdx] < nums[currIdx]){
                    sortableByLeftRotate = false;
                }
                if(nums[nextIdxMax] > nums[currIdxMax]){
                    sortableByRightRotate = false;
                }

                lastSubarrayMax = nums[nextIdx];
            }
            
            if(!sortableByRightRotate && !sortableByLeftRotate) return false;
        }

        return true;
    }

}