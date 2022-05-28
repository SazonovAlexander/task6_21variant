package ru.vsu.cs.sazonov;


public interface TreeMapPriorityQueue {

    void insert(Integer key, Object value);

    Object extract();

    String toText();

}
