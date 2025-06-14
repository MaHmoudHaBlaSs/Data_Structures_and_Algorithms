///   https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26]; 
        for(int i=0;i < s.length(); i++) freq[s.charAt(i)-'a']++;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int f : freq) if(f!=0) arr.add(f);

        Collections.sort(arr);
        int ans = 0; 
        
        for(int i=arr.size() - 2; i >= 0; i--){
            if(arr.get(i) < arr.get(i+1)) continue;

            if(arr.get(i+1) == 0) {
                ans += arr.get(i);
                arr.set(i, 0);
            }
            else {
                ans += arr.get(i) - arr.get(i+1) + 1;
                arr.set(i, arr.get(i+1) - 1);
            }
        }

        return ans; 
    }
}