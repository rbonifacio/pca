pub mod bellmanford;
pub mod common;
pub mod dijkstra;
pub mod graph_generator;
use std::time::Instant;

use bellmanford::shortest_path as bf_shortest_path;
use dijkstra::shortest_path as dj_shortest_path;

use crate::graph_generator::generate_graph;

fn benchmark(n: usize) {
    print!("{}\t", n);
    let graph = generate_graph(n);

    let start = Instant::now();
    dj_shortest_path(&graph, 0, 1);
    let duration = start.elapsed();

    print!("{}\t", duration.as_micros());

    let start = Instant::now();
    bf_shortest_path(&graph, 0, 1);
    let duration = start.elapsed();
    println!("{}", duration.as_micros());
}

fn main() {
    for i in 2..120 {
        benchmark(i);
    }
}
