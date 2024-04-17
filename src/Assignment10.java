import java.util.LinkedList;

public class Assignment10 {
    private static final int MAX_CAPACITY = 29;
    private LinkedList<Entry>[] table;

    public Assignment10() {
        table = new LinkedList[MAX_CAPACITY];
        for (int i = 0; i < MAX_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(String key, String value) {
        int hash = hashFunction(key);
        LinkedList<Entry> chain = table[hash];
        for (Entry entry : chain) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        chain.add(new Entry(key, value));
    }

    public String search(String key) {
        int hash = hashFunction(key);
        LinkedList<Entry> chain = table[hash];
        for (Entry entry : chain) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    private int hashFunction(String key) {
        return Math.abs(key.hashCode() % MAX_CAPACITY);
    }

    private static class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Assignment10 hashTable = new Assignment10();

        // Inserting students
        hashTable.insert("1", "Yanyu Chen");
        hashTable.insert("2", "Sixing Lu");
        hashTable.insert("3", "Hao Meng");
        hashTable.insert("4", "Ganesh Reddy Narahari");
        hashTable.insert("5", "Pankaj Penmetcha");
        hashTable.insert("6", "Saman Salimzade");
        hashTable.insert("7", "Yizhi Wang");
        hashTable.insert("8", "Binbin Wu");
        hashTable.insert("9", "Kunpeng Wu");
        hashTable.insert("10", "Wenyu You");

        // Insert two new students: Soniya Chatti ,  Nesal Cruz
        hashTable.insert("11", "Soniya Chatti");
        hashTable.insert("12", "Nesal Cruz");

        //Search for Soniya Chatti
        String Soniya = hashTable.search("11");
        System.out.println("Soniya Chatti: " + Soniya);
    }
}
