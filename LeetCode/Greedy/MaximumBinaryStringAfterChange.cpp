/// https://leetcode.com/problems/maximum-binary-string-after-change/description/

class Solution {
public:
    string maximumBinaryString(string binary) {
        int zeros = 0, firstZero = -1;
        for(int i=binary.length()-1; i>=0; --i){
            if(binary[i] == '0'){
                ++zeros;
                firstZero = i;
            }
        }

        if(zeros <= 1) return binary;


        int zeroIdx = firstZero + zeros - 1;
        binary.assign(binary.length(), '1');
        binary[zeroIdx] = '0';

        return binary; 
    }
};