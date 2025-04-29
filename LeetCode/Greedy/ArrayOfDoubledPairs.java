///  https://leetcode.com/problems/array-of-doubled-pairs/

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr); 

        HashMap<Integer, Integer> mp = new HashMap<>(); 
        for(int i=0; i<arr.length;){
            int j=i;
            while(j+1 < arr.length && arr[j+1] == arr[j]) 
                j++;

            mp.put(arr[i], j-i+1); 
            i=j+1;
        }

        if(mp.getOrDefault(0,0) % 2 != 0) return false; 

        int tokenNums = 0; 
        for(int n : arr){
            if(mp.get(n) > 0){
                if(mp.getOrDefault(n*2, 0)  > 0){
                    tokenNums += 2;
                    mp.put(n, mp.get(n) - 1);
                    mp.put(n*2, mp.get(n*2) - 1);
                }
            }
        }       

        return tokenNums == arr.length;  
    }
}