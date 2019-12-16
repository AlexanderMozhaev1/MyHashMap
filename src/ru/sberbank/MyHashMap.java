package ru.sberbank;

public class MyHashMap<K, V> {
    private int capacity = 16;// – вместимость/емкость (текущий размер массива)
    private int size = 0;//– количество элементов, находящихся в HashMap
    private final float loadFactor = 0.75f;// – коэффициент загрузки;
    private int threshold;// – пороговое значение количества элементов HashMap'а.
    private MyNode<K, V>[] arr;
    private MyNode<K, V> node;

    private int hash;

    public MyHashMap() {
        this.threshold = (int) (capacity * loadFactor);
        this.arr = (MyNode<K, V>[]) new MyNode[capacity];
    }

    public void put(K key, V val) {
        hash = key.hashCode() % capacity;

        if (arr[hash] == null) {
            arr[hash] = new MyNode<K, V>(key, val);
            return;
        }

        if (arr[hash].getKey().equals(key))
            arr[hash].setVal(val);

        node = arr[hash];

        while (node.next != null) {
            if (node.next.getKey().equals(key)) {
                node.next.setVal(val);
                break;
            }
        }

        if (node.next == null) {
            node.next = new MyNode<K, V>(key, val);
        }

        if (size++ >= threshold) {
            resize();
        }
    }

    public V get(K key) {
        hash = key.hashCode() % capacity;
        node = arr[hash];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getVal();
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        hash = key.hashCode() % capacity;

        if (arr[hash] == null) {
            return null;
        }

        if (arr[hash].getKey().equals(key)) {
            V _val = arr[hash].getVal();
            arr[hash] = arr[hash].next;
            size--;
            return _val;
        }

        node = arr[hash];

        while (node.next != null) {
            if (node.next.getKey().equals(key)) {
                V _val = node.next.getVal();
                node.next = node.next.next;
                size--;
                return _val;
            }
        }
        return null;
    }

    public boolean contains(K key) {
        hash = key.hashCode() % capacity;
        node = arr[hash];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    private void resize() {
        this.capacity *= 2;
        MyNode<K, V>[] _arr = this.arr;
        this.threshold = (int) (capacity * loadFactor);
        this.arr = (MyNode<K, V>[]) new MyNode[capacity];
        size = 0;
        for (MyNode<K, V> _node : _arr) {
            node = _node;
            while (node != null) {
                put(node.getKey(), node.getVal());
                node = node.next;
            }
        }
    }
}


