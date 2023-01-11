package br.unb.cic.algorithms.graphs.mst;

import br.unb.cic.algorithms.graphs.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KruskalTest {
    private Graph<Character> graph;

    @Before
    public void setUp() {
        graph = new Graph<>(GraphType.Undirected);

        Vertice<Character> a = new Vertice<>('a');
        Vertice<Character> b = new Vertice<>('b');
        Vertice<Character> c = new Vertice<>('c');
        Vertice<Character> d = new Vertice<>('d');
        Vertice<Character> e = new Vertice<>('e');
        Vertice<Character> f = new Vertice<>('f');
        Vertice<Character> g = new Vertice<>('g');
        Vertice<Character> h = new Vertice<>('h');
        Vertice<Character> i = new Vertice<>('i');

        graph.addVertice(a);
        graph.addVertice(b);
        graph.addVertice(c);
        graph.addVertice(d);
        graph.addVertice(e);
        graph.addVertice(f);
        graph.addVertice(g);
        graph.addVertice(h);
        graph.addVertice(i);

        graph.addEdge(a, b, 4);
        graph.addEdge(a, h, 8);
        graph.addEdge(b, c, 11);
        graph.addEdge(b, h, 8);
        graph.addEdge(c, d, 7);
        graph.addEdge(c, f, 4);
        graph.addEdge(c, i, 2);
        graph.addEdge(d, e, 9);
        graph.addEdge(d, f, 14);
        graph.addEdge(e, f, 10);
        graph.addEdge(f, g, 2);
        graph.addEdge(g, i, 6);
        graph.addEdge(g, h, 1);
        graph.addEdge(i, h, 7);
    }

    @Test
    public void testKruskalAlgorithm() {
        Assert.assertEquals(9, graph.vertices.size());
        Assert.assertEquals(14, graph.edges.size());

        Kruskal<Character> kruskal = new Kruskal<>();

        kruskal.minimumSpanningTree(graph);
    }


}
