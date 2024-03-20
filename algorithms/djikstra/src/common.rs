use std::collections::LinkedList;

pub struct Graph {
    // Every vertex has a list of (Node, Weight)
    pub vertexes: Vec<LinkedList<(usize, u64)>>,
}

pub const INFINITY: u64 = 1000;

pub fn find_path_from_prev(prev: Vec<Option<usize>>, target: usize) -> LinkedList<usize> {
    let mut path: LinkedList<usize> = LinkedList::from([target]);
    let mut current = target;
    while let Some(&Some(vertex)) = prev.get(current) {
        path.push_front(vertex);
        current = vertex;
    }

    return path;
}
