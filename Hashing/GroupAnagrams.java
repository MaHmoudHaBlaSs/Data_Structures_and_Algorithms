// https://leetcode.com/problems/group-anagrams/description/

class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>(); 
        
        for (String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            
            if (anagrams.containsKey(sorted))
                anagrams.get(sorted).add(str);
            else 
                anagrams.put(sorted, new ArrayList<>(List.of(str)));
        }
        return new ArrayList<>(anagrams.values());
    }
}
