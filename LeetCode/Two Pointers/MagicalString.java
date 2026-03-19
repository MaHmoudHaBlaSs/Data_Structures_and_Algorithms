// https://leetcode.com/problems/magical-string/

class Solution {    
    public static int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        List<Character> list = new ArrayList<>();
        list.add('1');
        list.add('2');
        list.add('2');
        int lIdx = 2 , count = 1;
        while (list.size() < n) {
            char repetition = list.get(lIdx++);
            char next = list.get(list.size() - 1) == '1' ? '2' : '1';

            int times = repetition - '0';

            for (int i = 0; i < times && list.size() < n; i++) {
                list.add(next);
                if (next == '1') count++;
            }

        }

        return count;
    }
}

class Solution {
    public int magicalString(int n) {
        int ones = 1;
        Deque<Integer> dq = new LinkedList<>(List.of(1, 1));

        n -= 3;
        while (n-- > 0) {
            int polled = dq.pollFirst();
            ones += (polled == 1)? 1: 0;

            int next = (dq.getLast() == 1)? 2: 1;
            while (polled-- > 0)
                dq.addLast(next);
        }
        return ones;
    }
}