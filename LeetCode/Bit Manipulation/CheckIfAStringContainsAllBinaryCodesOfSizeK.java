///  https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/

class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> nums = new HashSet();
        
        int i=0, n = s.length(), num=0;
        while(i<n){
            num <<= 1;
            num = manipulate(num, 0, s.charAt(i)=='1');
            ++i;
            
            if(i >= k){
                num = manipulate(num, k, false);
                nums.add(num);
            }
        }
        
        return nums.size() == (1<<k);
    }

    private int manipulate(int num, int bit, boolean set){
        if(set) return num | (1<<bit);

        return num & (~(1<<bit));
    }
}