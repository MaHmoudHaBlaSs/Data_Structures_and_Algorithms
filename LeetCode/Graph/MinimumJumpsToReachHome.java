///  https://leetcode.com/problems/minimum-jumps-to-reach-home/description/


class Solution {
    private final int FORWARD = 0, BACKWARD = 1;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int pos : forbidden) forbiddenSet.add(pos);
        int maxLimit = 2000 + 2 * Math.max(a, b);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, FORWARD, 0));

        Set<Node> visited = new HashSet<>();
        visited.add(new Node(0, FORWARD, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.position == x) 
                return curr.jumps; 

            int nextPosForward = curr.position + a;
            Node nextForward = new Node(nextPosForward, FORWARD, curr.jumps + 1);
            if (nextPosForward <= maxLimit 
                && !forbiddenSet.contains(nextPosForward) 
                && !visited.contains(nextForward)) {
                visited.add(nextForward);
                queue.offer(nextForward);
            }

            if (curr.prevState == FORWARD) {
                int nextPosBackward = curr.position - b;
                Node nextBackward = new Node(nextPosBackward, BACKWARD, curr.jumps + 1);
                if (nextPosBackward >= 0 
                    && !forbiddenSet.contains(nextPosBackward) 
                    && !visited.contains(nextBackward)) {
                    visited.add(nextBackward);
                    queue.offer(nextBackward);
                }
            }
        }

        return -1; 
    }

    private class Node implements Comparable<Node> {
        int position, prevState, jumps;
        public Node(int position, int prevState, int jumps) {
            this.position = position;
            this.prevState = prevState;
            this.jumps = jumps;
        }

        @Override
        public int compareTo(Node other) {
            return this.jumps - other.jumps;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return position == node.position && prevState == node.prevState;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, prevState);
        }
    }
}