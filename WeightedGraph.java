import java.util.*;
public class WeightedGraph<V>{
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
    private void validateVertex(Vertex<V> vertex) {
        if (!adjacencyList.containsKey(vertex))
            throw new IllegalArgumentException("Vertex " + vertex + " is not in the graph");
    }
    public void removeEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);

        source.getAdjacentVertices().remove(destination);
        destination.getAdjacentVertices().remove(source);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);

        return source.getAdjacentVertices().containsKey(destination);
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        validateVertex(vertex);
        return adjacencyList.get(vertex);
    }
    public void BFS(Vertex<V> start) {
        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        for (Vertex<V> vertex : adjacencyList.keySet()) {
            visited.put(vertex, false);
        }

        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.put(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.poll();
            System.out.print(vertex.getData() + " ");

            List<Vertex<V>> neighbors = adjacencyList.get(vertex);
            for (Vertex<V> neighbor : neighbors) {
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
    }
}
