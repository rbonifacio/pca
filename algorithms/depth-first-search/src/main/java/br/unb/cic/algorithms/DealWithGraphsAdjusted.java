package br.unb.cic.algorithms;

import br.unb.cic.algorithms.graph.*;
import br.unb.cic.algorithms.graph.enums.CoresEnum;
import br.unb.cic.algorithms.graph.enums.EdgeTypeEnum;
import br.unb.cic.algorithms.graph.util.Time;

import java.util.ArrayList;

public class DealWithGraphsAdjusted {

    public GraphAdjusted createGraphFromMatrix(int[][] matrix) {
        GraphAdjusted graph = new GraphAdjusted();

        for (int i = 0; i < matrix.length; i++) {
            VertexAdjusted vertex = new VertexAdjusted(String.valueOf(i));
            graph.addVertex(String.valueOf(i), vertex);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    VertexAdjusted startVertex = graph.getVertexByName(String.valueOf(i));
                    VertexAdjusted endVertex = graph.getVertexByName(String.valueOf(j));
                    EdgeAdjusted edge = new EdgeAdjusted(startVertex, endVertex);
                    startVertex.addEdge(edge);
                    graph.addEdge(edge);
                }
            }
        }

        return graph;
    }

    public GraphAdjusted createGraphFromAList(int[][] list) {
        GraphAdjusted graph = new GraphAdjusted();

        for (int i = 0; i < list.length; i++) {
            VertexAdjusted vertex = new VertexAdjusted(String.valueOf(i));
            graph.addVertex(String.valueOf(i), vertex);
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                VertexAdjusted startVertex = graph.getVertexByName(String.valueOf(i));
                VertexAdjusted endVertex = graph.getVertexByName(String.valueOf(list[i][j]));
                EdgeAdjusted edge = new EdgeAdjusted(startVertex, endVertex);
                startVertex.addEdge(edge);
                graph.addEdge(edge);
            }
        }

        return graph;
    }

    public void DFS(GraphAdjusted graph) {
        for (int i = 0; i < graph.getVertices().size(); i++) {
            graph.getVertexByName(String.valueOf(i)).setColor(CoresEnum.WHITE);
        }

        Time time = new Time();

        for (int i = 0; i < graph.getVertices().size(); i++) {
            VertexAdjusted vertex = graph.getVertexByName(String.valueOf(i));
            if (vertex.getColor() == CoresEnum.WHITE) {
                DFS_VISIT(vertex, time);
            }
        }
    }

    private void DFS_VISIT(VertexAdjusted vertex, Time time) {
        time.add();
        vertex.setTimeInit(time.getValue());
        vertex.setColor(CoresEnum.GREY);
        ArrayList<EdgeAdjusted> edges = vertex.getEdges();
        for (EdgeAdjusted edge : edges) {
            VertexAdjusted insideVertex = edge.getEndVertex();
            insideVertex.addΠ(vertex);
            if (insideVertex.getColor() == CoresEnum.WHITE) {
                edge.setType(EdgeTypeEnum.T);
                DFS_VISIT(insideVertex, time);
            } else if (insideVertex.getColor() == CoresEnum.GREY) {
                edge.setType(EdgeTypeEnum.B);
            } else if (insideVertex.getColor() == CoresEnum.BLACK) {
                if (verifyIfVertexIsADescendant(vertex, insideVertex)) {
                    edge.setType(EdgeTypeEnum.F);
                } else {
                    edge.setType(EdgeTypeEnum.C);
                    insideVertex.addΠ(vertex);
                }
            }
        }
        time.add();
        vertex.setColor(CoresEnum.BLACK);
        vertex.setTimeEnd(time.getValue());
    }


    public boolean verifyIfVertexIsADescendant(VertexAdjusted vertexRoot, VertexAdjusted vertex) {
        if (null == vertex.getΠ()) {
            return false;
        }

        if (vertex.getΠ().contains(vertexRoot)) {
            return true;
        }

        boolean descendant = false;

        for (int i =  0; i < vertex.getΠ().size(); i++){
            descendant = verifyIfVertexIsADescendant(vertexRoot, vertex.getΠ().get(i));
            if(descendant) {
                break;
            }
        }

        return descendant;
    }
}
