package br.unb.cic.algorithms.graphs;

public class Edge<T> {
    public Vertice<T> source;
    public Vertice<T> target;

    public Edge(Vertice<T> source, Vertice<T> target) {
        this.source = source;
        this.target = target;
    }
}
