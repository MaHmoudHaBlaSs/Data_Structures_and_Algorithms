/// https://leetcode.com/problems/minimum-operations-to-make-binary-palindrome/description/

class Solution {
    public int[] minOperations(int[] nums) {
        int n = nums.length; 
        int[] ans = new int[n];
        ArrayList<Integer> palindromes = new ArrayList<>(); 

        for(int i=0; i<=5017; ++i) {
            if(isBinaryPalindrome(i)) 
                palindromes.add(i);
        }

        for(int i=0; i<n; ++i){
            int num = nums[i];
            int right = palindromes.size()-1, left = 0, closest = 0;

            while(left <= right){
                int mid = (left+right) >> 1;

                if(palindromes.get(mid) <= num){
                    left = mid+1;  
                    closest = mid;
                }
                else right = mid-1; 
            }

            ans[i] = num - palindromes.get(closest); 

            if(closest+1 < palindromes.size()) {
                ans[i] = Integer.min(ans[i], palindromes.get(closest+1)-num); 
            }
        }

        return ans;
    }

    public boolean isBinaryPalindrome(int num) {
        int left = 0,right = 0;

        while((1<<(right+1)) <= num) right++;

        while (left < right) {
            if (((num>>left) & 1) != ((num>>right) & 1)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
