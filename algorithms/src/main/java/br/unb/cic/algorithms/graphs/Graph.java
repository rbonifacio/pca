package br.unb.cic.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph<T> {
    public Set<Vertice<T>> vertices;
    public Set<Edge<T>> edges;
    public GraphType type;

    public Graph() {
        this(GraphType.Undirected);
    }

    public Graph(GraphType type) {
        this.type = type;
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    public void addVertice(Vertice<T> vertice) {
        vertices.add(vertice);
    }

    public void addEdge(Vertice<T> value1, Vertice<T> value2) {
        edges.add(new Edge<>(value1, value2));
    }

    public void addEdge(Vertice<T> value1, Vertice<T> value2, int weight) {
        edges.add(new WeightedEdge<T, Integer>(value1, value2, weight));
    }
}
