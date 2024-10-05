package Tree;

class MaxHeap {
    private Integer[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new Integer[capacity + 1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(int data) {
        if (size == heap.length - 1) {
            resize(heap.length * 2);
        }
        size++;
        heap[size] = data;
        swim(size);
    }

    public void resize(int newCapacity) {
        Integer[] temp = new Integer[newCapacity];
        System.arraycopy(heap, 0, temp, 0, heap.length);

//        // Manual
//        for (int i = 0; i < heap.length; i++) {
//            temp[i] = heap[i];
//        }

        heap = temp;
    }

    public void swim(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public int delete() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap[1];
        swap(size, 1);
        // OPTIONAL extra measure for delete //
        // Set heap[size] (a.k.a current last index in heap)
        // to null first then size--
        heap[size] = null;
        //////////////////////////////
        size--;
        sink(1);
        return max;
    }

    public void sink(int k) {
        while (2 * k <= size) {
            // Has 1 child
            if (2 * k + 1 > size) {
                // Left child < parent
                if (heap[2 * k] <= heap[k]) {
                    return;
                } else {
                    // Swap child with parent
                    swap(k, 2 * k);
                }

            }
            // Has 2 children
            else {
                // Both children <= parent
                if (heap[2 * k] <= heap[k] && heap[2 * k + 1] <= heap[k]) {
                    return;
                }
                // Swap the bigger of the 2 children with parent
                if (heap[2 * k] > heap[2 * k + 1]) {
                    // Left child bigger
                    swap(k, 2 * k);
                } else {
                    // Right child bigger
                    swap(k, 2 * k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxHeap myHeap = new MaxHeap(3);
        myHeap.insert(40);
        myHeap.insert(12);
        myHeap.insert(39);
        myHeap.insert(6);
        myHeap.insert(4);
        myHeap.insert(38);
        myHeap.printHeap();
        System.out.println(myHeap.delete());
        myHeap.printHeap();
        System.out.println(myHeap.delete());
        myHeap.printHeap();
    }
}
