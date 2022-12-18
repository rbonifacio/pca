package br.unb.cic.algorithms;

import br.unb.cic.algorithms.graph.*;
import br.unb.cic.algorithms.graph.enums.CoresEnum;
import br.unb.cic.algorithms.graph.enums.EdgeTypeEnum;
import br.unb.cic.algorithms.graph.util.Time;

import java.util.ArrayList;

public class DealWithGraphsOriginal  {

    public GraphOriginal createGraphFromMatrix(int[][] matrix) {
        GraphOriginal graph = new GraphOriginal();

        for (int i = 0; i < matrix.length; i++) {
            VertexOriginal vertex = new VertexOriginal(String.valueOf(i));
            graph.addVertex(String.valueOf(i), vertex);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    VertexOriginal startVertex = graph.getVertexByName(String.valueOf(i));
                    VertexOriginal endVertex = graph.getVertexByName(String.valueOf(j));
                    EdgeOriginal edge = new EdgeOriginal(startVertex, endVertex);
                    startVertex.addEdge(edge);
                    graph.addEdge(edge);
                }
            }
        }

        return graph;
    }

    public GraphOriginal createGraphFromAList(int[][] list) {
        GraphOriginal graph = new GraphOriginal();

        for (int i = 0; i < list.length; i++) {
            VertexOriginal vertex = new VertexOriginal(String.valueOf(i));
            graph.addVertex(String.valueOf(i), vertex);
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                VertexOriginal startVertex = graph.getVertexByName(String.valueOf(i));
                VertexOriginal endVertex = graph.getVertexByName(String.valueOf(list[i][j]));
                EdgeOriginal edge = new EdgeOriginal(startVertex, endVertex);
                startVertex.addEdge(edge);
                graph.addEdge(edge);
            }
        }

        return graph;
    }

    public void DFS(GraphOriginal graph) {
        for (int i = 0; i < graph.getVertices().size(); i++) {
            graph.getVertexByName(String.valueOf(i)).setColor(CoresEnum.WHITE);
            graph.getVertexByName(String.valueOf(i)).setΠ(null);
        }

        Time time = new Time();

        for (int i = 0; i < graph.getVertices().size(); i++) {
            VertexOriginal vertex = graph.getVertexByName(String.valueOf(i));
            if (vertex.getColor() == CoresEnum.WHITE) {
                DFS_VISIT(vertex, time);
            }
        }
    }

    private void DFS_VISIT(VertexOriginal vertex, Time time) {
        time.add();
        vertex.setTimeInit(time.getValue());
        vertex.setColor(CoresEnum.GREY);
        for (EdgeOriginal edge : vertex.getEdges()) { // G.Adj[u]
            VertexOriginal insideVertex = edge.getEndVertex();
            if (insideVertex.getColor() == CoresEnum.WHITE) {
                edge.setType(EdgeTypeEnum.T);
                insideVertex.setΠ(vertex);
                DFS_VISIT(insideVertex, time);
            } else if (insideVertex.getColor() == CoresEnum.GREY) {
                edge.setType(EdgeTypeEnum.B);
            } else if (insideVertex.getColor() == CoresEnum.BLACK) {
                if (verifyIfVertexIsADescendant(vertex, insideVertex)) {
                    edge.setType(EdgeTypeEnum.F);
                } else {
                    edge.setType(EdgeTypeEnum.C);
                }
            }
        }
        time.add();
        vertex.setColor(CoresEnum.BLACK);
        vertex.setTimeEnd(time.getValue());
    }

    public boolean verifyIfVertexIsADescendant(VertexOriginal vertexRoot, VertexOriginal vertex) {
        if (null == vertex.getΠ()) {
            return false;
        }

        if (vertex.getΠ() == vertexRoot) {
            return true;
        }

        return verifyIfVertexIsADescendant(vertexRoot, vertex.getΠ());
    }
}
