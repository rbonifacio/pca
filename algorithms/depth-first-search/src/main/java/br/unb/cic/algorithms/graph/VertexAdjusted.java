package br.unb.cic.algorithms.graph;

import br.unb.cic.algorithms.graph.model.Vertex;

import java.util.ArrayList;

public class VertexAdjusted extends Vertex {

    public VertexAdjusted(String name) {
        super(name);
    }

    ArrayList<VertexAdjusted> π = new ArrayList<VertexAdjusted>();

    ArrayList<EdgeAdjusted> edges = new ArrayList<EdgeAdjusted>();

    public ArrayList<EdgeAdjusted> getEdges() {
        return edges;
    }

    public void addEdge(EdgeAdjusted edge) {
        edges.add(edge);
    }

    public ArrayList<VertexAdjusted> getΠ() {
        return π;
    }

    public void addΠ(VertexAdjusted vertexAdjusted) {
        if(null == π){
            π = new ArrayList<VertexAdjusted>();
        }
        π.add(vertexAdjusted);
    }
}
