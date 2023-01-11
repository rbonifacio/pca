package br.unb.cic.algorithms.graphs.mst;

import br.unb.cic.algorithms.graphs.Edge;
import br.unb.cic.algorithms.graphs.Graph;
import br.unb.cic.algorithms.graphs.Vertice;
import br.unb.cic.algorithms.graphs.WeightedEdge;
import br.unb.cic.algorithms.util.DisjointSet;
import br.unb.cic.algorithms.util.DisjointSetImpl;

import java.util.*;

public class Kruskal<T> {
    public Set<Edge<T>> minimumSpanningTree(Graph<T> g) {
        Set<Edge<T>> mst = new HashSet<>();
        DisjointSet<T> set = new DisjointSetImpl<>();

        for(Vertice<T> v: g.vertices) {
            set.makeSet(v.value);
        }
        List<WeightedEdge<T, Integer>> sortedEdges = new ArrayList<>();

        for(Edge e: g.edges) {
            sortedEdges.add((WeightedEdge<T, Integer>)e);
        }
        Collections.sort(sortedEdges, (e1,  e2) -> e1.weight - e2.weight);

        for(WeightedEdge<T, Integer> e: sortedEdges) {
            if(! set.findSet(e.source.value).equals(set.findSet(e.target.value))) {
                mst.add(e);
                set.mergeSets(e.source.value, e.target.value);
            }
        }
        return mst;
    }
}
