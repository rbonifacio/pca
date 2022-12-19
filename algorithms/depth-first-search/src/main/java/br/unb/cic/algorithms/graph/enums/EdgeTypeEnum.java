package br.unb.cic.algorithms.graph.enums;

public enum EdgeTypeEnum {
    T("TreeEdge"),
    B("BackEdge"),
    C("CrossEdge"),
    F("ForwardEdge");

    private String description;

    EdgeTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
