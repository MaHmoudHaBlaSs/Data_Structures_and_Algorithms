import java.util.Stack;

public class MinStack {
    class Node{
        int val, min;
        Node next;
    }
    Stack<Node> stack = new Stack<>();

    public void push(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (stack.isEmpty())
            newNode.min = val;
        else{
            newNode.min = Math.min(val, stack.peek().min); // OR `(val < stack.peek().min)?val:stack.peek().min;`
        }
        stack.push(newNode);
    }

    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

}