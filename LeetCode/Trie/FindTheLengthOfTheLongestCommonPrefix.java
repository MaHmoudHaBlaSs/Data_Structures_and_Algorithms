///  https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        DigitTrie trie = new DigitTrie();

        for(int num : arr1) trie.add(num);

        int ans = 0;
        for(int num : arr2){
            ans = Integer.max(ans, trie.longestCommonPrefix(num));
        }

        return ans; 
    }

    static class DigitTrie {
        private static class TrieNode{
            DigitTrie.TrieNode[] children = new TrieNode[10];
            int count;
        }

        private DigitTrie.TrieNode root = new DigitTrie.TrieNode();

        public void add(int num){
            String numStr = Integer.toString(num);
            TrieNode curr  = root;
            
            for(int i=0; i<numStr.length(); ++i){
                int idx = numStr.charAt(i) - '0';
                
                if(curr.children[idx] == null){
                    curr.children[idx] = new TrieNode();
                }
                
                curr = curr.children[idx];
                curr.count++;
            }
        }
        
        public int longestCommonPrefix(int num){
            String numStr = Integer.toString(num);
            int len = 0;
            TrieNode curr  = root;

            for(int i=0; i<numStr.length(); ++i){
                int idx = numStr.charAt(i) - '0';

                if(curr.children[idx] == null){
                    break;
                }

                curr = curr.children[idx];
                len++;
            }
            
            return len;
        }
    }    
}