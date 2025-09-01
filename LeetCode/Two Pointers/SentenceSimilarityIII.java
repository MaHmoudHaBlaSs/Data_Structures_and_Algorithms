///  https://leetcode.com/problems/sentence-similarity-iii/description/


class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int n1 = s1.length, n2 = s2.length;
        int i=0, j=0;
        while(i < n1 && j < n2 && s1[i].equals(s2[j])){
            i++;
            j++;
        }

        if(i == n1 || j == n2) return true;

        int k = 0, l = 0;
        while(k < n1 && l < n2 && s1[n1-k-1].equals(s2[n2-l-1])){
            k++;
            l++;
        }

        if(k == n1 || l == n2) return true;
        if(k + i  >= n1 || l + j >= n2) return true;

        return false;
    }
}