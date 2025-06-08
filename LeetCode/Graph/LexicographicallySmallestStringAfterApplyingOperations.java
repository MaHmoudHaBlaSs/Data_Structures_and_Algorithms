///  https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        String result = s;

        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (current.compareTo(result) < 0) 
                result = current;

            String added = add(current, a);
            String rotated = rotate(current, b);

            if (visited.add(added)) 
                queue.offer(added);
            
            if (visited.add(rotated)) 
                queue.offer(rotated);
        }

        return result;
    }

    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        
        for (int i = 1; i < chars.length; i += 2) {
            int digit = chars[i] - '0';
            chars[i] = (char)('0' + (digit + a) % 10);
        }
        
        return new String(chars);
    }

    private String rotate(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }
}