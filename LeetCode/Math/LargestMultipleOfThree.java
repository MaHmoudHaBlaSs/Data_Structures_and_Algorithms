/// https://leetcode.com/problems/largest-multiple-of-three/description/

/*
    sum % 3 == 0 → use all digits
    sum % 3 == 1 → remove:
    - one digit ≡ 1 (mod 3), OR
    - two digits ≡ 2 (mod 3)
    sum % 3 == 2 → remove:
    - one digit ≡ 2 (mod 3), OR
    - two digits ≡ 1 (mod 3)
 
*/


class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] freq = new int[10];
        int sum = 0;
        for(int digit : digits) {
            sum += digit;
            freq[digit]++;
        }

        if(sum % 3 == 0) return construct(freq);
        else if(sum%3 == 1){
            for(int i=1; i<10; i+=3) {
                if(freq[i] > 0) {
                    freq[i]--;
                    return construct(freq);    
                }
            }

            for(int i=2; i<10; i+=3){
                for(int j=i; j<10; j+=3){
                    if((i==j && freq[i] > 1) || (i!= j && freq[i] > 0 && freq[j] > 0)){
                        freq[i]--; freq[j]--;
                        return construct(freq);   
                    }
                }
            }  
        }else{
            for(int i=2; i<10; i+=3) {
                if(freq[i] > 0) {
                    freq[i]--;
                    return construct(freq);    
                }
            }  

            for(int i=1; i<10; i+=3){
                for(int j=i; j<10; j+=3){
                    if((i==j && freq[i] > 1) || (i!= j && freq[i] > 0 && freq[j] > 0)){
                        freq[i]--; freq[j]--;
                        return construct(freq);   
                    }
                }
            }        
        }
        return "";
    }

    private String construct(int[] freq){
        boolean nonZero = false;
        StringBuilder sb  =new StringBuilder();

        for(int i=9; i>0; --i){
            while(freq[i]-- > 0){
                sb.append(i);
            }
        }

        if(sb.length() == 0) return freq[0] == 0 ? "" : "0";

        while(freq[0]-- > 0){
            sb.append(0);
        }
        
        return sb.toString();
    }
}