package ru.sberbank;

public class MyNode<K,V> {
    private K key;
    private V val;
    MyNode<K,V> next;

    public void setVal(V val) {
        this.val = val;
    }

    public MyNode(K key, V val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }

    public V getVal() {
        return val;
    }

    public K getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "key=" + key +
                ", val=" + val +
                ", next=" + next +
                '}';
    }
}
