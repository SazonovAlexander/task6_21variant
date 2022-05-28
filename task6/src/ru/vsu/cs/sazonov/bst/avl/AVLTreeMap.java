package ru.vsu.cs.sazonov.bst.avl;

import ru.vsu.cs.sazonov.bst.BSTree;
import ru.vsu.cs.sazonov.bst.BSTreeMap;

/**
 * Реализация словаря на базе АВЛ-деревьев
 *
 * @param <K>
 * @param <V>
 */
public class AVLTreeMap<K extends Comparable<K>, V> implements BSTreeMap<K, V> {

    private final BSTree<MapTreeEntry<K, V>> tree = new AVLTree<>();

    @Override
    public BSTree<MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
