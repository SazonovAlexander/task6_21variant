package ru.vsu.cs.sazonov.bst.rb;

import ru.vsu.cs.sazonov.bst.BSTree;
import ru.vsu.cs.sazonov.bst.BSTreeMap;

/**
 * Реализация словаря на базе красно-черных деревьев
 *
 * @param <K>
 * @param <V>
 */
public class RBTreeMap<K extends Comparable<K>, V> implements BSTreeMap<K, V> {

    private final BSTree<MapTreeEntry<K, V>> tree = new RBTree<>();

    @Override
    public BSTree<MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
