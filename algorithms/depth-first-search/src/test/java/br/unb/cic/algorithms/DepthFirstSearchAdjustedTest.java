package br.unb.cic.algorithms;

import br.unb.cic.algorithms.graph.EdgeAdjusted;
import br.unb.cic.algorithms.graph.GraphAdjusted;
import br.unb.cic.algorithms.graph.VertexAdjusted;
import br.unb.cic.algorithms.graph.enums.CoresEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepthFirstSearchAdjustedTest {

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

        final VertexAdjusted expectedVertex = new VertexAdjusted("3");
        expectedVertex.setColor(CoresEnum.BLACK);
        expectedVertex.setTimeInit(4);
        expectedVertex.setTimeEnd(5);
        expectedVertex.addΠ(new VertexAdjusted(""));
        expectedVertex.addΠ(new VertexAdjusted(""));
        expectedVertex.getEdges().add(new EdgeAdjusted(null, null));

        DealWithGraphsAdjusted dealWithGraphsAdjusted = new DealWithGraphsAdjusted();
        GraphAdjusted graph = dealWithGraphsAdjusted.createGraphFromMatrix(matrix);

        dealWithGraphsAdjusted.DFS(graph);

        VertexAdjusted vertexOne = graph.getVertices().get("3");
        assertEquals(expectedVertex.getColor(), vertexOne.getColor());
        assertEquals(expectedVertex.getName(), vertexOne.getName());
        assertEquals(expectedVertex.getTimeInit(), vertexOne.getTimeInit());
        assertEquals(expectedVertex.getTimeEnd(), vertexOne.getTimeEnd());
        assertEquals(expectedVertex.getEdges().size(), vertexOne.getEdges().size());
        assertEquals(expectedVertex.getΠ().size(), vertexOne.getΠ().size());
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

        final VertexAdjusted expectedVertex = new VertexAdjusted("4");
        expectedVertex.setColor(CoresEnum.BLACK);
        expectedVertex.setTimeInit(3);
        expectedVertex.setTimeEnd(6);
        expectedVertex.addΠ(new VertexAdjusted(""));
        expectedVertex.addΠ(new VertexAdjusted(""));
        expectedVertex.getEdges().add(new EdgeAdjusted(null, null));

        DealWithGraphsAdjusted dealWithGraphsAdjusted = new DealWithGraphsAdjusted();
        GraphAdjusted graph = dealWithGraphsAdjusted.createGraphFromAList(list);

        dealWithGraphsAdjusted.DFS(graph);

        VertexAdjusted vertexOne = graph.getVertices().get("4");
        assertEquals(expectedVertex.getColor(), vertexOne.getColor());
        assertEquals(expectedVertex.getName(), vertexOne.getName());
        assertEquals(expectedVertex.getTimeInit(), vertexOne.getTimeInit());
        assertEquals(expectedVertex.getTimeEnd(), vertexOne.getTimeEnd());
        assertEquals(expectedVertex.getEdges().size(), vertexOne.getEdges().size());
        assertEquals(expectedVertex.getΠ().size(), vertexOne.getΠ().size());
        System.out.println(vertexOne);

        VertexAdjusted vertexTwo = graph.getVertices().get("3");
        assertTrue(vertexTwo.getΠ().contains(vertexOne));
    }
}
