package HashTable;

class HashTable {
    private final int capacity;
    private int size;
    private final HashNode[] buckets;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new HashNode[capacity];
    }


    static class HashNode {
        private final Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int calculateIndex(Integer key) {
        return key % capacity;
    }

    public int calculateIndex(String key) {
        return key.hashCode() % capacity;
    }

    // Insert entry
    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value is null");
        }
        int index = calculateIndex(key);
        HashNode head = buckets[index];
        HashNode newNode = new HashNode(key, value);
        if (buckets[index] == null) {
            buckets[index] = newNode;
            size++;
            return;
        }
        // InsertAtHead
        HashNode current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;


        // InsertAtEnd
//        HashNode current = buckets[index];
//        HashNode previous = null;
//        while (current != null) {
//            if (current.key.equals(key)) {
//                current.value = value;
//                return;
//            }
//            previous = current;
//            current = current.next;
//        }
//        assert previous != null;
//        previous.next = newNode;
//        size++;
    }

    // Get value
    public String get(Integer key) {
        int index = calculateIndex(key);
        HashNode current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    // Remove entry
    public String remove(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        if (this.isEmpty()) {
            return null;
        }
        int index = calculateIndex(key);
        HashNode current = buckets[index];
        if (current.key.equals(key)) {
            buckets[index] = current.next;
            size--;
            return current.value;
        }
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                HashNode tmp = current.next;
                current.next = current.next.next;
                size--;
                return tmp.value;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(101, "Linh");
        table.put(348, "An");
        table.put(256, "Hang");
        table.put(511, "Vu");
        table.put(348, "Phuong");

        System.out.println(table.get(511));

        System.out.println(table.remove(348));

    }
}
