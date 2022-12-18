package br.unb.cic.algorithms.graph;

import br.unb.cic.algorithms.graph.model.Edge;

public class EdgeOriginal extends Edge {

    public EdgeOriginal(VertexOriginal startVertex, VertexOriginal endVertex){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }
    VertexOriginal startVertex;
    VertexOriginal endVertex;

    public VertexOriginal getStartVertex() {
        return startVertex;
    }

    public VertexOriginal getEndVertex() {
        return endVertex;
    }
    
    @Override
    public String toString() {
        return "\n\tEdge{" +
                "startVertex=" + startVertex.getName() +
                ", endVertex=" + endVertex.getName() +
                ", type=" + this.getType() +
                '}';
    }
}
