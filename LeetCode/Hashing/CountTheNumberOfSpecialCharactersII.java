///  https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/

class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26], upper = new boolean[26];
        int[] arr = new int[26];

        final int UN_EXPLORED = -1, SPECIAL = 1, UN_SPECIAL = 0;
        Arrays.fill(arr, UN_EXPLORED);

        for(int i=0; i<word.length(); ++i){
            char c = word.charAt(i);

            if(Character.isUpperCase(c)){
                int j = c-'A';

                if(lower[j]){
                    if(arr[j] == UN_EXPLORED){
                        arr[j] = SPECIAL;  
                    }
                }

                upper[j] = true;

            }else{
                int j = c-'a';

                if(upper[j]){
                    arr[j] = UN_SPECIAL;
                }
                lower[j] = true;  
            }
        }

        int c = 0;
        for(int num : arr){
            if(num == SPECIAL) c++;
        }

        return c;
    }
}
