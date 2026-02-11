///  https://leetcode.com/problems/rearrange-words-in-a-sentence/description/


class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] =  words[0].toLowerCase();

        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) ->{
            if(n1.word.length() !=  n2.word.length()){
                return n1.word.length() - n2.word.length();
            }

            return n1.pos - n2.pos;
        });
        
        for (int i = 0; i < words.length; i++) {
            pq.offer(new Node(words[i],i));    
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().word);
            sb.append(" ");
        }

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }


    private static class Node{
        String word;
        int pos;
        Node(String word, int pos){
            this.word = word;
            this.pos = pos;
        }
    }
}
