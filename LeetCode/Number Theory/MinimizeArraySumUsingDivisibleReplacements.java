///  https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/description/

class Solution {
    public long minArraySum(int[] nums) {
        long ans = 0;
        
        int max = Arrays.stream(nums).max().getAsInt();
        int[] arr = new int[max+1];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            arr[num] = num;
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        for(int i=1; i<=max; ++i){

            if(arr[i] == i){
                for(int m=i; m<=max; m += i){
                    if(arr[m] != 0 && arr[m] == m){
                        arr[m] = i;
                    }
                }
            }
        }

        for(int i=1; i<=max; ++i){ 
            ans += (long)arr[i] * freq.getOrDefault(i,0);
        }

        return ans;
    }
}