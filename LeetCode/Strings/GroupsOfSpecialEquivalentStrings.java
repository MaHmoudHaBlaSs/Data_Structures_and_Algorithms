///  https://leetcode.com/problems/groups-of-special-equivalent-strings/

// O(N∗M∗Log(M))
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<String> set = new HashSet<>(); 

        for(String word : words){
            char[] arr = word.toCharArray(); 
            String odd = "", even = ""; 
            for(int i=0; i< arr.length; i++){
                if(i % 2 == 0) even = even + arr[i];
                else odd = odd + arr[i];
            }

            set.add( sort(odd) + sort(even)) ; 
        }

        return set.size(); 
    }

    private String sort(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}