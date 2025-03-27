///   https://leetcode.com/problems/k-similar-strings/

/*
The greedy approach which generate all possible combinations and add them to the queue will break the time limit

Key optimization: 
    Before generating new states, check if the characters actually need to be swapped
    Skip swaps that don't improve the string's similarity 
*/


class Solution {
    public int kSimilarity(String s1, String s2) {
        int k=0, len = s1.length(); 
        
        HashSet<String> vis = new HashSet<>(); 
        Queue<String> q = new LinkedList<>(); 
        
        q.offer(s1);
        vis.add(s1); 

        while(!q.isEmpty()){
            int size = q.size(); 
            while(size-- > 0){
                String top = q.poll();
                if(top.equals(s2)) return k; 

                for(String str : getNeighbors(top, s2)){
                    if(vis.contains(str)) continue;

                    vis.add(str); 
                    q.offer(str); 
                }
            }
            k++;
        }

        return k; 
    }

    private List<String> getNeighbors(String s, String target){
        List<String> ans = new ArrayList<>(); 
        int firstDiff = 0; 
        char[] arr  = s.toCharArray(); 

        while(firstDiff < s.length() && arr[firstDiff] == target.charAt(firstDiff))
            firstDiff++;
        
        char ch = arr[firstDiff], targetChar = target.charAt(firstDiff);
        for(int i=firstDiff+1; i<arr.length; i++){
            if(arr[i] != targetChar) continue; 

            arr[firstDiff] = targetChar; 
            arr[i] = ch; 

            ans.add(new String(arr)); 

            arr[firstDiff] = ch; 
            arr[i] = targetChar;
        }

        return ans; 
    }
}