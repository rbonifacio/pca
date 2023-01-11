package br.unb.cic.algorithms.util;


import java.util.Set;

public interface DisjointSet<T> {
    void makeSet(T value);
    Set<DisjointSetNode<T>> findSet(T value);
    void mergeSets(T value1, T value2);
}
