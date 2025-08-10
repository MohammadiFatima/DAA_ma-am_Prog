public class Dijkstra {

    int dist[];   // dist[i] stores the shortest distance from the source vertex to vertex i
    int S[];      // S[i] is 1 if vertex i has been visited, 0 if not
    int n;        // number of vertices in the graph
    int cost[][]; // adjacency matrix holding the edge weights between vertices

    // Constructor: sets up the graph with 6 vertices and the cost matrix
    public Dijkstra() {
        n = 6; // we have 6 vertices (numbered 0 to 5)

        // cost[i][j] represents the weight of the edge from i to j
        // Integer.MAX_VALUE means "no direct edge" (infinity)
        cost = new int[][] {
            {0, 50, 45, 10, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, 10, 15, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 30, Integer.MAX_VALUE},
            {20, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 15, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 20, 35, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 0},
        };

        // initialize distance and visited arrays
        dist = new int[n];
        S = new int[n];
    }

    // Finds the shortest paths from vertex v to all other vertices
    public void shortestPaths(int v) {
        // Step 1: Initialize distances and mark all vertices as unvisited
        for (int i = 0; i < n; i++) {
            S[i] = 0;           // all vertices are initially unvisited
            dist[i] = cost[v][i]; // set initial distance to direct edge from v
        }

        S[v] = 1;    // mark the start vertex as visited
        dist[v] = 0; // distance from v to itself is 0

        // Step 2: Repeat to visit all remaining vertices
        for (int i = 1; i < n - 1; i++) {
            // Pick the unvisited vertex with the smallest tentative distance
            int u = minDist();
            S[u] = 1; // mark this vertex as visited

            // Step 3: Update distances to neighbors of u
            for (int w = 0; w < n; w++) {
                // Only consider unvisited neighbors with a valid edge
                if (cost[u][w] != 0 &&
                    cost[u][w] != Integer.MAX_VALUE &&
                    S[w] == 0) {

                    // If the new path through u is shorter, update dist[w]
                    if (dist[w] > dist[u] + cost[u][w]) {
                        dist[w] = dist[u] + cost[u][w];
                    }
                }
            }
        }
    }

    // Returns the index of the unvisited vertex with the smallest distance
    public int minDist() {
        int min = Integer.MAX_VALUE; // start with infinity
        int u = -1;                  // no vertex chosen yet

        for (int i = 0; i < n; i++) {
            // choose the smallest distance among unvisited vertices
            if (dist[i] < min && S[i] != 1) {
                min = dist[i];
                u = i;
            }
        }
        return u;
    }

    // Prints the final shortest distances from the source vertex
    public void displayDist() {
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF\t"); // unreachable vertex
            } else {
                System.out.print(dist[i] + "\t"); // print distance value
            }
        }
        System.out.println(); // move to next line after printing all distances
    }

    // Main method: creates the Dijkstra object and runs the shortest path algorithm
    public static void main(String args[]) {
        Dijkstra d = new Dijkstra();
        d.shortestPaths(0);  // start from vertex 0
        d.displayDist();     // show distances from vertex 0 to all others
    }
}
