///  https://leetcode.com/problems/first-element-with-unique-frequency/description/

class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        HashMap<Integer, Integer> freqFreq = new HashMap<>();

        for(int num : nums){
            numFreq.put(num, numFreq.getOrDefault(num, 0)+1); 
        }
        for(Integer freq : numFreq.values()){
            freqFreq.put(freq, freqFreq.getOrDefault(freq,0)+1); 
        }
        
        for (int num : nums){
            if(freqFreq.get(numFreq.get(num)) == 1) return num; 
        }
        
        return -1; 
    }
}