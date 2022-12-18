package br.unb.cic.algorithms;

import br.unb.cic.algorithms.graph.*;
import br.unb.cic.algorithms.graph.enums.CoresEnum;

import static org.junit.Assert.*;
import org.junit.Test;

public class DepthFirstSearchOriginalTest {

    @Test
    public void testVisitVerticesUsingAMatrixAsSource() {

        final int[] matrix[] = {
                {0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1}
        };

        final VertexOriginal expectedVertex = new VertexOriginal("0");
        expectedVertex.setColor(CoresEnum.BLACK);
        expectedVertex.setΠ(null);
        expectedVertex.setTimeInit(1);
        expectedVertex.setTimeEnd(8);
        expectedVertex.getEdges().add(new EdgeOriginal(null, null));
        expectedVertex.getEdges().add(new EdgeOriginal(null, null));

        DealWithGraphsOriginal dealWithGraphsOriginal = new DealWithGraphsOriginal();
        GraphOriginal graph = dealWithGraphsOriginal.createGraphFromMatrix(matrix);

        dealWithGraphsOriginal.DFS(graph);

        VertexOriginal vertexOne = graph.getVertices().get("0");
        assertEquals(expectedVertex.getColor(), vertexOne.getColor());
        assertEquals(expectedVertex.getName(), vertexOne.getName());
        assertEquals(expectedVertex.getTimeInit(), vertexOne.getTimeInit());
        assertEquals(expectedVertex.getTimeEnd(), vertexOne.getTimeEnd());
        assertEquals(expectedVertex.getEdges().size(), vertexOne.getEdges().size());
        assertEquals(expectedVertex.getΠ(), vertexOne.getΠ());
    }

    @Test
    public void testVisitVerticesUsingAListAsSource() {

        final int[] list[] = {
                {1, 3},
                {4},
                {4, 5},
                {1},
                {3},
                {5}
        };

        final VertexOriginal expectedVertex = new VertexOriginal("0");
        expectedVertex.setColor(CoresEnum.BLACK);
        expectedVertex.setΠ(null);
        expectedVertex.setTimeInit(1);
        expectedVertex.setTimeEnd(8);
        expectedVertex.getEdges().add(new EdgeOriginal(null, null));
        expectedVertex.getEdges().add(new EdgeOriginal(null, null));

        DealWithGraphsOriginal dealWithGraphsOriginal = new DealWithGraphsOriginal();
        GraphOriginal graph = dealWithGraphsOriginal.createGraphFromAList(list);

        dealWithGraphsOriginal.DFS(graph);

        VertexOriginal vertexOne = graph.getVertices().get("0");
        assertEquals(expectedVertex.getColor(), vertexOne.getColor());
        assertEquals(expectedVertex.getName(), vertexOne.getName());
        assertEquals(expectedVertex.getTimeInit(), vertexOne.getTimeInit());
        assertEquals(expectedVertex.getTimeEnd(), vertexOne.getTimeEnd());
        assertEquals(expectedVertex.getEdges().size(), vertexOne.getEdges().size());
        assertEquals(expectedVertex.getΠ(), vertexOne.getΠ());

        VertexOriginal vertexTwo = graph.getVertices().get("1");
        assertEquals(vertexTwo.getΠ(), vertexOne);
    }

    }
