import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Example usage:
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        graph.addEdge(vertexA, vertexB, 1.0);
        graph.addEdge(vertexA, vertexC, 2.0);
        graph.addEdge(vertexB, vertexD, 3.0);
        graph.addEdge(vertexC, vertexD, 1.5);
        graph.addEdge(vertexC, vertexE, 2.5);
        graph.addEdge(vertexD, vertexE, 1.0);

        // Print the graph
        System.out.println("Graph:");
        graph.printGraph();

        // Perform breadth-first search (BFS)
        Search<String> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("\nBFS:");
        bfs.search(vertexA);

        // Perform Dijkstra's algorithm
        Search<String> dijkstra = new DijkstraSearch<>(graph);
        System.out.println("\nDijkstra's Algorithm:");
        dijkstra.search(vertexA);

        // Validate the distances obtained from Dijkstra's algorithm
        Map<Vertex<String>, Double> distances = graph.Dijkstra(vertexA);
        System.out.println("\nValidating Dijkstra's algorithm results:");
        for (Map.Entry<Vertex<String>, Double> entry : distances.entrySet()) {
            Vertex<String> vertex = entry.getKey();
            double distance = entry.getValue();
            System.out.println("Distance from A to " + vertex.getData() + ": " + distance);
        }
    }
}