package br.unb.cic.algorithms.graphs;

public class WeightedEdge<T, W> extends Edge<T>  {

    public W weight;

    public WeightedEdge(Vertice<T> source, Vertice<T> target, W weight) {
        super(source, target);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", source.value, target.value, weight);
    }
}
