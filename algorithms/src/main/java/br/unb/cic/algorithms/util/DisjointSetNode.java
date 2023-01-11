package br.unb.cic.algorithms.util;

public class DisjointSetNode<T> {
    T value;
    int index;

    public DisjointSetNode(T value, int index) {
        this.value = value;
        this.index = index;
    }
}