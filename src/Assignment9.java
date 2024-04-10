// Implement priority queue using array and heap

public class Assignment9 {
    private final int capacity;
    private final Pair[] heap;
    private int size;

    public Assignment9(int capacity) {
        this.capacity = capacity;
        heap = new Pair[capacity];
        size = 0;
    }

    public void push(String value, int priority) {
        if (size == capacity) {
            return;
        }
        heap[size] = new Pair(value, priority);
        heapifyUp(size);
        size++;
    }

    public String pop() {
        if (size == 0) {
            return null;
        }
        String root = heap[0].value;
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[parent].priority > heap[index].priority) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int minChild;
        while (2 * index + 1 < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (rightChild < size && heap[rightChild].priority < heap[leftChild].priority) {
                minChild = rightChild;
            } else {
                minChild = leftChild;
            }
            if (heap[index].priority <= heap[minChild].priority) {
                break;
            }
            swap(index, minChild);
            index = minChild;
        }
    }

    private void swap(int i, int j) {
        Pair temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        Assignment9 pq = new Assignment9(5);
        pq.push("a", 3);
        pq.push("c", 2);
        pq.push("b", 4);
        pq.push("d", 1);
        pq.push("e", 5);

        System.out.println("First Popped item: " + pq.pop());
        System.out.println("Second Popped item: " + pq.pop());
        System.out.println("Third Popped item: " + pq.pop());
    }

    private class Pair {
        String value;
        int priority;

        public Pair(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}
