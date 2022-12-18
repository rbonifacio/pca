package br.unb.cic.algorithms.graph;

import br.unb.cic.algorithms.graph.model.Graph;

import java.util.HashMap;

public class GraphOriginal extends Graph {

    HashMap<String, VertexOriginal> vertices = new HashMap<String, VertexOriginal>();

    public HashMap<String, VertexOriginal> getVertices() {
        if(vertices == null) {
            vertices = new HashMap<String, VertexOriginal>();
        }
        return vertices;
    }

    public VertexOriginal getVertexByName(String name) {
        return this.vertices.get(name);
    }

    public void addVertex(String key, VertexOriginal vertex) {
        this.vertices.put(key, vertex);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "\nvertices=" + vertices +
                ", \nedges=" + this.getEdges() +
                '}';
    }

}
