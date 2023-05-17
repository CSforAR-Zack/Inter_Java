import java.util.ArrayList;

public class Queue {
    private ArrayList<Integer> queue = new ArrayList<Integer>();

    public void enqueue(int n) {
        queue.add(n);
    }

    public int dequeue() {
        return queue.remove(0);
    }

    public int peek() {
        return queue.get(0);
    }

    public ArrayList<Integer> getQueue() {
        return queue;
    }
}
