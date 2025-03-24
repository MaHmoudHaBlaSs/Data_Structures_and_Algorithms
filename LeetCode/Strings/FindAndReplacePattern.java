///  https://leetcode.com/problems/find-and-replace-pattern/


class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] arr1 = pattern.toCharArray(); 
        List<String> ans = new ArrayList<>(); 

        for(String word : words){
            if(word.length() != arr1.length) continue;

            HashMap<Character,Character> mp = new HashMap<>();
            char[] arr2 = word.toCharArray(); 
            boolean[] vis = new boolean[26]; 
            boolean okk = true;

            for(int i=0; i<arr1.length; i++){
                if(!mp.containsKey(arr1[i])) {
                    if(vis[arr2[i]-'a']){
                        okk=  false;
                        break;
                    }
                    mp.put(arr1[i], arr2[i]); 
                    vis[arr2[i]-'a']= true;
                }
                else if(mp.get(arr1[i]) != arr2[i]) {
                    okk = false;
                    break;
                }
            }

            if(okk) ans.add(word); 
        }  

        return ans;  
    }
}