package br.unb.cic.algorithms.graph.model;

import br.unb.cic.algorithms.graph.model.Edge;

import java.util.ArrayList;

public abstract class Graph {

    public Graph() {
    }


    ArrayList<Edge> edges = new ArrayList<Edge>();

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        if(edges == null){
            edges = new ArrayList<Edge>();
        }
        edges.add(edge);
    }


}
