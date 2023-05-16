import java.util.LinkedList;

public class Stack {
    LinkedList<Integer> stack = new LinkedList<Integer>();

    public void push(int n) {
        stack.push(n);
    }

    public int pop() {
        return stack.pop();
    }
}
