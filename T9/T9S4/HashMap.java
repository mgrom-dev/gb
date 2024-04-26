import java.util.Iterator;

public class HashMap<K, V> implements Iterable<HashMap<K, V>.Entity> {
    private static final int INIT_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.5;
    private Bucket[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new HashMap.Bucket[INIT_BUCKET_COUNT];
    }

    @SuppressWarnings("unchecked")
    public HashMap(int initCount) {
        buckets = new HashMap.Bucket[initCount];
    }

    @Override
    public Iterator<Entity> iterator() {
        return new HashMapIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Buckets:\n");
        for (int i = 0, p = 1; i < buckets.length; i++)
            if (buckets[i] != null) 
                sb.append(p++ + ". id(").append(i).append("): ").append(buckets[i]).append("\n");
        return sb.toString();
    }

    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    
    @SuppressWarnings("unchecked")
    private void recalculate() {
        size = 0;
        Bucket[] old = buckets;
        buckets = new HashMap.Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Bucket bucket = old[i];
            if (bucket != null) {
                Bucket.Node node = bucket.head;
                while (node != null) {
                    put(node.value.key, node.value.value);
                    node = node.next;
                }
            }
        }
    }

    public V put(K key, V value) {
        if (size >= buckets.length * LOAD_FACTOR) {
            recalculate();
        }

        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        V buf = bucket.add(entity);
        if (buf == null) {
            size++;
        }
        return buf;
    }

    public V get(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        return bucket.get(key);
    }

    public V remove(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        V buf = bucket.remove(key);
        if (buf != null) size--;
        return buf;
    }

    /** Для перебора элементов с помощью цикла foreach */
    class HashMapIterator implements Iterator<Entity> {
        private int index = 0;
        private Entity current = null;
        private HashMap<K, V>.Bucket.Node currentNode = null;

        public HashMapIterator() {
            if (size > 0) {
                current = getNextBucket();
            }
        }

        private Entity getNextBucket() {
            while (index < buckets.length && buckets[index] == null)
                index++;
            if (index >= buckets.length) return null;
            if (currentNode == null) currentNode = buckets[index].head;
            else currentNode = currentNode.next;
            if (currentNode == null) {
                index++;
                currentNode = null;
                return getNextBucket();
            }
            return currentNode.value;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Entity next() {
            Entity entity = current;
            current = getNextBucket();
            return entity;
        }
        
    }

    /** Элемент хэш таблицы */
    class Entity {
        K key; // Ключ
        V value; // Значение элемента
    }

    /** Бакет, связанный список */
    class Bucket {
        Node head; // первый элемент связанного списка

        public V add(Entity entity) {
            Node node = new Node();
            node.value = entity;

            if (head == null) {
                head = node;
                return null;
            }

            Node current = head;
            while (true) {
                if (current.value.key.equals(entity.key)) {
                    V buf = current.value.value;
                    current.value.value = entity.value;
                    return buf;
                }
                if (current.next != null) {
                    current = current.next;
                } else {
                    current.next = node;
                    return null;
                }
            }
        }

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key))
                    return node.value.value;
                node = node.next;
            }
            return null;
        }

        public V remove(K key) {
            if (head == null) {
                return null;
            }
            if (head.value.key.equals(key)) {
                V buf = head.value.value;
                head = head.next;
                return buf;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.value.key.equals(key)) {
                        V buf = node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }

        /** Узел бакета (связанного списка) */
        class Node {
            Node next; // Указатель на следующий элемент хэш таблицы
            Entity value; // значение узла указывающее на элемент хэш таблицы
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{ ");
            Node node = head;
            while (node != null) {
                sb.append(node.value.key).append(": ").append(node.value.value);
                node = node.next;
                if (node != null) sb.append(", ");
            }
            return sb.append(" }").toString();
        }
    }
}