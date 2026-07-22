// https://leetcode.com/problems/my-calendar-i/

// The Best Solution is to use a BST.
// Time: O(log(n)) worst is O(n) time complexity, where n is the number of events booked so far.
// Space: O(n)
class MyCalendar {
    static class Node {
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Node() {

        }

        public boolean insert(int start, int end, Node node) {
            if (start >= node.end) {
                if (node.right == null) {
                    node.right = new Node(start, end);
                    return true;
                } else
                    return insert(start, end, node.right);
            }

            if (end <= node.start) {
                if (node.left == null) {
                    node.left = new Node(start, end);
                    return true;
                } else
                    return insert(start, end, node.left);
            }

            return false;
        }
    }

    Node calendar;

    public MyCalendar() {
        calendar = new Node();
    }

    public boolean book(int startTime, int endTime) {
        return calendar.insert(startTime, endTime, calendar);
    }
}