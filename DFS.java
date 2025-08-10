public class DFS {

    public int vertices;      // Number of vertices in the graph
    public int adjMat[][];    // Adjacency matrix representation of the graph
    public int visited[];     // Array to track visited vertices

    // Constructor: Initializes graph data
    public DFS() {
        vertices = 8;  // The graph has 8 vertices (numbered 0 to 7)

        // Initialize visited array with all zeros (meaning unvisited)
        visited = new int[vertices];

        // Define the adjacency matrix
        // 1 means there is an edge between the two vertices, 0 means no edge
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

    // Depth First Search function starting from vertex s
    public void dfs(int s) {
        // Only visit if the vertex is not yet visited
        if (visited[s] == 0) {
            System.out.print(s + " "); // Print the vertex as we visit it
            visited[s] = 1;            // Mark it as visited

            // Explore all adjacent vertices
            for (int j = 0; j < vertices; j++) {
                // If there is an edge from s to j and j is unvisited, recurse
                if (adjMat[s][j] == 1 && visited[j] == 0) {
                    dfs(j);
                }
            }
        }
    }

    // Main method to test DFS
    public static void main(String args[]) {
        DFS g = new DFS();  // Create graph instance
        System.out.println("DFS:");
        g.dfs(0);           // Start DFS from vertex 0
    }
}
