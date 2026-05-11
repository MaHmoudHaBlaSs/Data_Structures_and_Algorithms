///  https://leetcode.com/problems/find-the-score-difference-in-a-game/description/

class Solution {
    public int maxXor(int[] nums, int k) {
        BinaryTrie trie = new BinaryTrie(16);
        ArrayDeque<Integer> minDeque = new ArrayDeque<>(), maxDeque = new ArrayDeque<>();

        int left = 0, leftXOR = 0, rightXOR = 0, ans = 0;

        for(int right = 0; right <nums.length; right++){
            trie.add(rightXOR);
            rightXOR ^= nums[right];
            
            //update the max & min
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) minDeque.pollLast();
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) maxDeque.pollLast();
            minDeque.offerLast(right);
            maxDeque.offerLast(right);

            //keep the window valid
            while(left < right && nums[maxDeque.peekFirst()]-nums[minDeque.peekFirst()] > k){
                trie.delete(leftXOR);
                leftXOR ^= nums[left++];

                if(minDeque.peekFirst() < left) minDeque.pollFirst();
                if(maxDeque.peekFirst() < left) maxDeque.pollFirst();
            }
            
            ans = Integer.max(ans, trie.maxXOR(rightXOR));
        }
        
        return ans;
    }

    static class BinaryTrie{
        private static class TrieNode{
            TrieNode zero, one;
            int onesCount = 0, zeroCount = 0;
        }

        private TrieNode root = new TrieNode();
        private final int numOfBits;


        BinaryTrie(int numOfBits) {
            this.numOfBits = numOfBits;
        }


        public void add(int num){
            var curr = root;

            for (int i = this.numOfBits; i >= 0; --i) {
                boolean one = ((num>>i) & 1) == 0;

                if(one){
                    if(curr.one == null) curr.one = new TrieNode();

                    curr.onesCount++;
                    curr = curr.one;
                }else{
                    if(curr.zero == null) curr.zero = new TrieNode();

                    curr.zeroCount++;
                    curr = curr.zero;
                }
            }
        }

        public void delete(int num){
            var curr = root;

            for (int i = this.numOfBits; i >= 0; --i) {
                boolean one = ((num>>i) & 1) == 0;

                if(one){
                    curr.onesCount--;
                    curr = curr.one;
                }else{
                    curr.zeroCount--;
                    curr = curr.zero;
                }
            }
        }

        public int maxXOR(int num){
            var curr = root;
            int ans = 0;

            for (int i = this.numOfBits; i >= 0; --i) {
                boolean one = ((num>>i) & 1) == 0;

                if(one){
                    if(curr.zeroCount > 0) {
                        curr = curr.zero;
                        ans ^= (1<<i);
                    }
                    else{
                        curr = curr.one;
                    }
                }else{
                    if(curr.onesCount > 0) {
                        curr = curr.one;
                        ans ^= (1<<i);
                    }
                    else{
                        curr = curr.zero;
                    }
                }
            }

            return ans;
        }
    }
}