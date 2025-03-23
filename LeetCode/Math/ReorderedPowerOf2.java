///      https://leetcode.com/problems/reordered-power-of-2/


//Get all powers of 2, if any any one of them has the same digits as n, return true

//T:O(1)   Space: O(1) 
class Solution {
    public boolean reorderedPowerOf2(int n) {
        String nStr = String.valueOf(n);
        int[] nFreq = getFreq(nStr);

        for (int i = 0; i < 31; i++) { 
            String power = String.valueOf(1 << i);
            int[] freq = getFreq(power);

            if (areEqual(freq, nFreq)) 
                return true;
        }

        return false;
    }

    private int[] getFreq(String s) {
        int[] counts = new int[10];
        for (char c : s.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }

    private boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}