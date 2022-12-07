use crate::{common::find_path_from_prev, common::Graph, common::INFINITY};
use std::{cmp::Reverse, collections::LinkedList};

use priority_queue::PriorityQueue;

pub fn shortest_path(graph: &Graph, source: usize, target: usize) -> (u64, LinkedList<usize>) {
    let n = graph.vertexes.len();
    let mut dist = vec![INFINITY; n];
    let mut visited = vec![false; n];
    let mut prev: Vec<Option<usize>> = vec![None; n];
    let mut pq: PriorityQueue<usize, Reverse<u64>> = PriorityQueue::new();

    // Initial values for source
    dist[source] = 0;
    pq.push(source, Reverse(0));

    // Runs |V|+1 times, takes Tpop
    while let Some((u, _)) = pq.pop() {
        // Runs |V| times, takes 1
        if visited[u] {
            // Runs |V| times, takes 1
            continue;
        }

        // Runs |V| times, takes 1
        visited[u] = true;

        // Runs |V| times, takes 1
        // println!("Visiting {}", u);

        // Runs |V| * (|Ev|+1) times, takes 1
        for &(v, w) in &graph.vertexes[u] {
            // Runs |V| * |Ev| times, takes 1
            // println!(
            //     "Checking edge from u={} to v={} with weight w={}, dist[u] = {}, dist[v] = {}",
            //     u, v, w, dist[u], dist[v]
            // );

            // Runs |V| * |Ev| times, takes 1
            if dist[v] > dist[u] + w {
                // Runs |V| * |Ev| times, takes 1
                dist[v] = dist[u] + w;

                // Runs |V| * |Ev| times, takes 1
                prev[v] = Some(u);

                // Runs |V| * |Ev| times, takes 1
                // println!("Updated dist[{}] to {}", v, dist[v]);

                // Runs |V| * |Ev| times, takes Tpush
                pq.push(v, Reverse(dist[v]));
            }
        }
    }

    return (dist[target], find_path_from_prev(prev, target));
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn should_find_shortest_path() {
        let graph = Graph {
            vertexes: Vec::from([
                LinkedList::from([(1, 5), (2, 6)]), // 0
                LinkedList::from([(4, 100)]),       // 1
                LinkedList::from([(3, 5)]),         // 2
                LinkedList::from([(4, 7)]),         // 3
                LinkedList::from([]),               // 4
            ]),
        };

        let (dist, path) = shortest_path(&graph, 0, 4);

        assert_eq!(dist, 18);
        assert_eq!(path, LinkedList::from([0, 2, 3, 4]));
    }

    #[test]
    fn find_shortest_path_cormen_example() {
        let graph_cormen = Graph {
            vertexes: Vec::from([
                LinkedList::from([(1, 10), (4, 5)]),        // 0
                LinkedList::from([(2, 1), (4, 2)]),         // 1
                LinkedList::from([(3, 4)]),                 // 2
                LinkedList::from([(0, 7), (2, 6)]),         // 3
                LinkedList::from([(1, 3), (2, 9), (3, 2)]), // 4
            ]),
        };

        let (dist1, path1) = shortest_path(&graph_cormen, 0, 1);
        let (dist2, path2) = shortest_path(&graph_cormen, 0, 2);
        let (dist3, path3) = shortest_path(&graph_cormen, 0, 3);
        let (dist4, path4) = shortest_path(&graph_cormen, 0, 4);

        assert_eq!(dist1, 8);
        assert_eq!(dist2, 9);
        assert_eq!(dist3, 7);
        assert_eq!(dist4, 5);
        assert_eq!(path1, LinkedList::from([0, 4, 1]));
        assert_eq!(path2, LinkedList::from([0, 4, 1, 2]));
        assert_eq!(path3, LinkedList::from([0, 4, 3]));
        assert_eq!(path4, LinkedList::from([0, 4]));
    }

    #[test]
    fn should_not_find_shortest_path() {
        let graph = Graph {
            vertexes: Vec::from([
                LinkedList::from([(1, 5), (2, 6)]), // 0
                LinkedList::from([(4, 100)]),       // 1
                LinkedList::from([(3, 5)]),         // 2
                LinkedList::from([(4, 7)]),         // 3
                LinkedList::from([]),               // 4
            ]),
        };

        let (dist, path) = shortest_path(&graph, 4, 0);

        assert_eq!(dist, INFINITY);
        assert_eq!(path, LinkedList::from([0]));
    }
}
