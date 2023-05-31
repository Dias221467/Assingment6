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
}
