/// https://leetcode.com/problems/split-the-array-to-make-coprime-products/description/

class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        if(n == 1) return -1;

        HashMap<Integer, Integer> suffixFactors = new HashMap<>();
        HashSet<Integer> prefixFactors = new HashSet<>();
        Set<Integer>[] cache = new HashSet[n];

        for(int i=n-1; i>=0; --i){
            Set<Integer> factors = primeFactors(nums[i]);
            cache[i] = factors;

            for(int f : factors) {
                suffixFactors.put(f, suffixFactors.getOrDefault(f,0)+1);
            }
        }

        int totalFactors = suffixFactors.size();

        for(int i=0; i<n-1; ++i){
            Set<Integer> factors = cache[i];

            for(int f : factors) {
                int freq = suffixFactors.get(f)-1;

                if(freq == 0) suffixFactors.remove(f);
                else suffixFactors.put(f, freq);

                prefixFactors.add(f);
            }

            if(suffixFactors.size() + prefixFactors.size() == totalFactors)
                return i;
        }

        return -1;
    }

    
    private Set<Integer> primeFactors(int n){ //O(sqrt(n))
        Set<Integer> factors = new HashSet<>();

        for(int i=2; i*i <= n; i++){
            boolean flag = false;

            while(n%i==0){
                n /= i;
                flag = true;
            }

            if(flag) factors.add(i);
        }

        if(n != 1){
            factors.add(n);
        }

        return factors;
    }
    
}