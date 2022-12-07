use std::collections::LinkedList;

use crate::common::Graph;
use rand::Rng;

pub fn generate_graph(n: usize) -> Graph {
    let mut graph = Graph { vertexes: vec![] };
    let mut rng = rand::thread_rng();

    for _ in 0..n {
        let mut edges: LinkedList<(usize, u64)> = LinkedList::new();

        for v in 0..n {
            edges.push_back((v, rng.gen_range(1..99)));
        }

        graph.vertexes.push(edges);
    }

    return graph;
}
