/// https://leetcode.com/problems/orderly-queue/


/*
The key idea is that:
    if(k>1) 
        it means you can swap any two characters with each other so just sort the string and return it 
    else 
        -you can only take a substring (from i to i+n) and push it in the beging (0 to n) 
        -we need this substring to be smallest possible one 
        -first character in the result will be the smallest char in s
        -if the smallest char exists in 'indices', the start of the result will be the lexicographically smallest 
        string with length = s.length, starts from any index in the 'indecies'.
*/ 

//Time: O(n^2)              Space: O(n)
class Solution {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int len = arr.length;
        StringBuilder result = new StringBuilder();

        for(char c : arr) freq[c-'a']++;

        if(k > 1) {
            for(int i=0; i<26; i++){
                for(int j=0; j<freq[i]; j++){
                    result.append((char)(i+'a'));
                }
            }
            return result.toString();
        }


        char minChar = 'z';
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                minChar = (char)(i+'a');
                break;
            }
        }


        HashSet<Integer> minCharIndices = new HashSet<>();
        int smallestPart = 0;
        for(int i=0;i<len;i++) {
            if(arr[i] == minChar) {
                minCharIndices.add(i);
                smallestPart = i;
            }
        }


        for(int i=1; i<len;i++){
            char c = arr[(smallestPart + i)% len];
            if(minCharIndices.size() == 1)
                break;

            HashSet<Integer> temp = new HashSet<>();
            for(int index : minCharIndices){
                if(arr[(index+i) % len] < c){
                    c = arr[(index+i) % len];
                    temp.add(smallestPart);
                    smallestPart = index;
                }
                else if(arr[(index+i) % len] > c)
                    temp.add(index);
            }
            minCharIndices.removeAll(temp);
        }


        for(int i=0; i<len; i++){
            result.append(arr[(smallestPart+i)%len]);
        }

        return result.toString();
    }

}