///  https://leetcode.com/problems/fruit-into-baskets/

//T: O(n)         S: O(1)
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp = new HashMap<>(); 
        int right =  0, ans = 0, n = fruits.length; 

        for(int left=0; left<n && right<n; left++){

            while(right < n && (mp.size() < 2 || mp.containsKey(fruits[right])))
                mp.put(fruits[right], mp.getOrDefault(fruits[right++],0) + 1);

            if(right-left > ans) ans = right-left; 
            
            int freq = mp.get(fruits[left]); 
            if(freq == 1) mp.remove(fruits[left]);
            else mp.put(fruits[left], freq-1);  
        }

        return ans; 
    }
}