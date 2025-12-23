/// https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/

/*
    -Binary Trie to maximize the XOR
    -Sort the array and the queries, and maintain the trie such that 
    in each query the trie consists exactly of the valid elements <= m_i.
*/

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[][] nQueries = new int[n][3];
        
        for(int i=0; i<n; ++i){ 
            nQueries[i] = new int[] {queries[i][0], queries[i][1], i};
        }

        Arrays.sort(nQueries, (a,b) -> a[1] - b[1]);
        Arrays.sort(nums); 

        int numsIdx = 0; 
        int[] ans = new int[n]; 
        for(int i=0; i<n; ++i){
            int x = nQueries[i][0], m = nQueries[i][1], idx = nQueries[i][2]; 

            while(numsIdx < nums.length && nums[numsIdx] <= m) {
                add(nums[numsIdx++]);
            }

            ans[idx] = maxXOR(x);
        }

        return ans; 
    }
    
    private TrieNode root = new TrieNode();
    private void add(int num){
        TrieNode curr = root;

        for(int i=31; i>=0; --i){
            boolean one = ((num >> i) & 1) == 1;

            if(one){
                if(curr.one == null) 
                    curr.one = new TrieNode(); 
                curr = curr.one;
            }else{
                if(curr.zero == null) 
                    curr.zero = new TrieNode(); 
                curr = curr.zero;
            }
        }
    }

    private int maxXOR(int num){
        TrieNode curr = root;
        if(curr.zero == null && curr.one == null) return -1;

        for(int i=31; i>=0; --i){
            boolean one = ((num >> i) & 1) == 1;

            if(one){
                if(curr.zero != null){ 
                    curr = curr.zero;
                }else{
                    num ^= (1 << i);
                    curr = curr.one;
                }
            }else{
                if(curr.one != null){ 
                    curr = curr.one;
                    num ^= (1 << i);
                }else{
                    curr = curr.zero;
                }
            }
        } 

        return num;       
    }

    static class TrieNode{
        TrieNode zero, one;
    }
}