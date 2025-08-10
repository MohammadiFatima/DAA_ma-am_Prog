import java.util.*;

public class BFS {

    public int vertices;   // Number of vertices in the graph
    public int adjMat[][]; // Adjacency matrix representation of the graph

    // Constructor: Initializes the graph
    public BFS() {
        vertices = 8; // Graph has 8 vertices (0 to 7)

        // Adjacency matrix representation of the graph
        adjMat = new int[][]{
            {0, 1, 1, 0, 0, 0, 0, 0}, // Edges from vertex 0
            {1, 0, 0, 1, 1, 0, 0, 0}, // Edges from vertex 1
            {1, 0, 0, 0, 0, 1, 1, 0}, // Edges from vertex 2
            {0, 1, 0, 0, 0, 0, 0, 1}, // Edges from vertex 3
            {0, 1, 0, 0, 0, 0, 0, 1}, // Edges from vertex 4
            {0, 0, 1, 0, 0, 0, 0, 1}, // Edges from vertex 5
            {0, 0, 1, 0, 0, 0, 0, 1}, // Edges from vertex 6
            {0, 0, 0, 1, 1, 1, 1, 0}  // Edges from vertex 7
        };
    }

    // Breadth-First Search starting from vertex s
    public void bfs(int s) {
        int i = s; // Starting vertex

        // Create a queue to hold vertices to be explored
        Queue<Integer> q = new LinkedList<Integer>();

        // Array to track visited vertices
        int visited[] = new int[vertices];

        // Visit the starting vertex
        System.out.print(i + " ");
        visited[i] = 1; // Mark as visited
        q.add(i);       // Add to the queue

        // Continue until queue is empty
        while (!q.isEmpty()) {
            i = q.remove(); // Remove the front element from the queue

            // Check all possible neighbors of vertex i
            for (int j = 0; j < vertices; j++) {
                // If there is an edge and vertex j is unvisited
                if (adjMat[i][j] == 1 && visited[j] == 0) {
                    System.out.print(j + " "); // Visit vertex j
                    visited[j] = 1;            // Mark it as visited
                    q.add(j);                  // Add it to the queue
                }
            }
        }
    }

    // Main method to test BFS
    public static void main(String args[]) {
        BFS b = new BFS(); // Create BFS graph instance
        System.out.println("BFS:");
        b.bfs(0); // Start BFS from vertex 0
    }
}
