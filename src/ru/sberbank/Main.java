package ru.sberbank;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i*i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + map.remove(i));
        }

    }
}
