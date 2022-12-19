package br.unb.cic.algorithms.graph;

import br.unb.cic.algorithms.graph.enums.EdgeTypeEnum;
import br.unb.cic.algorithms.graph.model.Edge;

public class EdgeAdjusted extends Edge {

    public EdgeAdjusted(VertexAdjusted startVertex, VertexAdjusted endVertex){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }
    VertexAdjusted startVertex;
    VertexAdjusted endVertex;
    EdgeTypeEnum type;

    public EdgeTypeEnum getType() {
        return type;
    }

    public void setType(EdgeTypeEnum type) {
        this.type = type;
    }

    public VertexAdjusted getStartVertex() {
        return startVertex;
    }

    public VertexAdjusted getEndVertex() {
        return endVertex;
    }
    
    @Override
    public String toString() {
        return "\n\tEdge{" +
                "startVertex=" + startVertex.getName() +
                ", endVertex=" + endVertex.getName() +
                ", type=" + type +
                '}';
    }
}
