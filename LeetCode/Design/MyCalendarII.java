// https://leetcode.com/problems/my-calendar-ii/


// Time: O(m.n^2) where m is number of bookings
// Space: O(n)
// Beats 55%
// Time complexity can be enhanced if we implemented overlapping list using BST,
// as we did with My Calendar I problem.
class MyCalendarTwo {

    List<int[]> events;
    List<int[]> overlapping;

    public MyCalendarTwo() {
        events = new LinkedList<>();
        overlapping = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        for (int[] event : overlapping) {
            if (start < event[1] && end > event[0])
                return false;
        }

        for (int[] event : events) {
            if (start < event[1] && end > event[0])
                overlapping.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1]) });
        }
        events.add(new int[] { start, end });
        return true;
    }
}

// Solution using BST for overlapping.
// Time: O(m.n.log(n)) [better than O(n.m)]
// Space: O(n)
// Beats 94%
class MyCalendarTwo {
    static class Node {
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static boolean insert(int start, int end, Node node) {
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

        public static boolean checkOverlap(int start, int end, Node node) {
            if (start < node.end && end > node.start)
                return false;

            if (start >= node.end) {
                if (node.right == null)
                    return true;
                else
                    return checkOverlap(start, end, node.right);
            }

            if (end <= node.start) {
                if (node.left == null)
                    return true;
                else
                    return checkOverlap(start, end, node.left);
            }
            
            return true; // Filling return line
        }
    }

    List<int[]> events;
    Node overlapping;

    public MyCalendarTwo() {
        events = new LinkedList<>();
        overlapping = new Node(0, 0);
    }

    public boolean book(int start, int end) {
        if ( !Node.checkOverlap(start, end, overlapping) )
            return false;

        for ( int[] event : events ) {
            if ( start < event[1] && end > event[0] ) 
                Node.insert( Math.max(start, event[0]), Math.min(end, event[1]), overlapping );
        }

        events.add( new int[] { start, end } );
        return true;
    }
}