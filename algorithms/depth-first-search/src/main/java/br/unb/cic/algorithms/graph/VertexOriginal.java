package br.unb.cic.algorithms.graph;

import br.unb.cic.algorithms.graph.model.Vertex;

import java.util.ArrayList;

public class VertexOriginal extends Vertex {

    public VertexOriginal(String name) {
        super(name);
    }

    VertexOriginal π;

    ArrayList<EdgeOriginal> edges = new ArrayList<EdgeOriginal>();

    public ArrayList<EdgeOriginal> getEdges() {
        return edges;
    }

    public void addEdge(EdgeOriginal edge) {
        edges.add(edge);
    }

    public VertexOriginal getΠ() {
        return π;
    }

    public void setΠ(VertexOriginal π) {
        this.π = π;
    }

}
