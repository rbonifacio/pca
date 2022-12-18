package br.unb.cic.algorithms.graph;

import br.unb.cic.algorithms.graph.model.Graph;

import java.util.HashMap;

public class GraphAdjusted extends Graph {

    HashMap<String, VertexAdjusted> vertices = new HashMap<String, VertexAdjusted>();

    public HashMap<String, VertexAdjusted> getVertices() {
        if(vertices == null) {
            vertices = new HashMap<String, VertexAdjusted>();
        }
        return vertices;
    }

    public VertexAdjusted getVertexByName(String name) {
        return this.vertices.get(name);
    }

    public void addVertex(String key, VertexAdjusted vertex) {
        this.vertices.put(key, vertex);
    }

}
