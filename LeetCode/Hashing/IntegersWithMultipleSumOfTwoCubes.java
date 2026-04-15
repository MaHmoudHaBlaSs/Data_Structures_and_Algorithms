///  https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/description/  


class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i*i*i <= n; i++) {
            int aCubic = i*i*i;
            for (int j = i; aCubic+j*j*j <= n; j++) {
                int x = aCubic + j*j*j;
                int freq = mp.getOrDefault(x,0)+1;
                mp.put(x,freq);
                
                if(freq == 2) ans.add(x);
            }
        }
        
        ans.sort(Integer::compareTo);
        return ans; 
    }
}
