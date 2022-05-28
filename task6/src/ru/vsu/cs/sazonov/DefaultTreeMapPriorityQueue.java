package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.bst.BSTree;
import ru.vsu.cs.sazonov.bst.BSTreeMap;
import ru.vsu.cs.sazonov.bst.avl.AVLTree;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DefaultTreeMapPriorityQueue implements TreeMapPriorityQueue {

    private final TreeMap<Integer, TreeMap<Integer, Object>> queue = new TreeMap<>();

    @Override
    public void insert(Integer key, Object value){
        if (queue.containsKey(key)){
            int max = Integer.MIN_VALUE;
            for (Integer k:
                    queue.get(key).keySet()) {
                if (k > max) max = k;
            }
            queue.get(key).put(max+1, value);
        }
        else {
            TreeMap<Integer, Object> map = new TreeMap<>();
            map.put(1, value);
            queue.put(key, map);
        }
    }

    @Override
    public Object extract(){
        int min = Integer.MAX_VALUE;
        for (Integer key:
                queue.keySet()) {
            if (key < min) min = key;
        }
        if (queue.get(min).size() == 1)
            return queue.remove(min).get(1);
        else{
            List<Integer> index = queue.get(min).keySet().stream().toList();
            for (Integer k:
                    index) {
                queue.get(min).put(k-1, queue.get(min).remove(k));
            }
            return queue.get(min).remove(0);
        }
    }

    @Override
    public String toText(){
        StringBuilder sb = new StringBuilder();
        for (Integer key:
                queue.keySet()) {
            sb.append(key).append(" = ");
            StringBuilder sb1 = new StringBuilder();
            for (Integer key1:
                    queue.get(key).keySet()) {
                sb1.append(key1).append(" -> ").append(queue.get(key).get(key1)).append("; ");
            }
            sb.append(sb1).append("\n");
        }
        return sb.toString();
    }
}
