package br.unb.cic.algorithms.graph.model;

import br.unb.cic.algorithms.graph.enums.EdgeTypeEnum;

import java.util.ArrayList;

public abstract class Edge {
    EdgeTypeEnum type;

    public EdgeTypeEnum getType() {
        return type;
    }

    public void setType(EdgeTypeEnum type) {
        this.type = type;
    }
}
