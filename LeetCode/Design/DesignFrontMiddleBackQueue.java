///  https://leetcode.com/problems/design-front-middle-back-queue/description/

class FrontMiddleBackQueue {
    private Deque<Integer> left, right;
    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
        reset();
    }

    public void pushMiddle(int val) {
        if(left.size() > right.size())
            right.addFirst(left.removeLast());

        left.addLast(val);
        reset();
    }

    public void pushBack(int val) {
        right.addLast(val);
        reset();
    }

    public int popFront() {
        if(left.isEmpty()) return -1;

        int ans = left.removeFirst();
        reset();
        return ans;
    }

    public int popMiddle() {
        if(left.isEmpty()) return -1;

        int ans = left.removeLast();
        reset();
        return ans;
    }

    public int popBack() {
        int ans = -1;
        if(!right.isEmpty()) ans = right.removeLast();
        else if(!left.isEmpty()) ans = left.removeLast();

        reset();
        return ans;
    }

    private void reset(){
        if(right.size() > left.size()) left.addLast(right.removeFirst());

        if(left.size() - right.size() > 1) right.addFirst(left.removeLast());
    }
}
