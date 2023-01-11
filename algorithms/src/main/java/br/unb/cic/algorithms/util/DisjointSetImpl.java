package br.unb.cic.algorithms.util;

import java.security.InvalidParameterException;
import java.util.*;

public class DisjointSetImpl<T> implements DisjointSet<T> {
    Map<Integer, Set<DisjointSetNode<T>>> sets;
    Map<T, Integer> map;
    int count;

    public DisjointSetImpl() {
        sets = new HashMap<>();
        map = new HashMap<>();
        count = 0;
    }

    public void makeSet(T value) {
        if(map.containsKey(value)) {
            throw new InvalidParameterException(value + " already present in the set");
        }
        DisjointSetNode<T> node = new DisjointSetNode(value, count);
        Set<DisjointSetNode<T>> singleton = new HashSet<>();
        singleton.add(node);
        sets.put(count, singleton);
        map.put(value, count);
        count++;
    }

    public Set<DisjointSetNode<T>> findSet(T value) {
        if(! map.containsKey(value)) {
            throw new InvalidParameterException(value + " is not present in the set");
        }

        int idx = map.get(value);
        return sets.get(idx);
    }

    public void mergeSets(T value1, T value2) {
        Set<DisjointSetNode<T>> set1 = findSet(value1);
        Set<DisjointSetNode<T>> set2 = findSet(value2);

        int idx1 = map.get(value1);
        int idx2 = map.get(value2);

        sets.remove(idx1);
        sets.remove(idx2);

        set1.forEach(v -> map.put(v.value, count));
        set2.forEach(v -> map.put(v.value, count));

        set1.addAll(set2);
        sets.put(count, set1);
        count++;
    }
}
