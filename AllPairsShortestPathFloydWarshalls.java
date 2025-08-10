public class AllPairsShortestPathFloydWarshalls {

    int n;              // Number of vertices in the graph
    int cost[][];       // Initial cost/distance matrix
    int A[][];          // Matrix used for computing shortest paths
    int INF = Integer.MAX_VALUE; // Representation of "infinite" distance (no direct path)

    // Constructor to initialize the graph
    public AllPairsShortestPathFloydWarshalls() {
        n = 3; // We have 3 vertices in this example

        // Cost matrix: cost[i][j] = distance from vertex i to vertex j
        // INF means there is no direct edge between the vertices
        cost = new int[][]{
            {0, 4, 11},    // From vertex 0: to 0 cost=0, to 1 cost=4, to 2 cost=11
            {6, 0, 2},     // From vertex 1: to 0 cost=6, to 1 cost=0, to 2 cost=2
            {3, INF, 0}    // From vertex 2: to 0 cost=3, to 1 no path (INF), to 2 cost=0
        };

        // Initialize A matrix (will hold intermediate shortest path results)
        A = new int[n][n];
    }

    // Main method for computing shortest paths between all pairs
    public void AllPairs() {
        // Step 1: Initialize A with the initial cost matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = cost[i][j];

        // Display the starting matrix
        displayA();

        // Step 2: Floyd-Warshall algorithm core
        // k is the intermediate vertex we are allowing in the path
        for (int k = 0; k < n; k++) {
            // For every pair (i, j), try using vertex k as an intermediate
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    // Only proceed if both i→k and k→j paths exist
                    if (A[i][k] != INF && A[k][j] != INF)
                        // Update A[i][j] with the smaller of:
                        // - The current known distance
                        // - The distance through vertex k
                        A[i][j] = minValue(A[i][j], A[i][k] + A[k][j]);

            // Display the matrix after considering intermediate vertex k
            System.out.println("APSP between vertices with intermediate vertex K = " + k);
            displayA();
        }
    }

    // Utility method to return the smaller of two integers
    public int minValue(int x, int y) {
        return (x < y) ? x : y;
    }

    // Prints the current state of the A matrix
    public void displayA() {
        for (int i = 0; i < n; i++) {        // For each row
            for (int j = 0; j < n; j++) {    // For each column
                if (A[i][j] == Integer.MAX_VALUE) // If distance is INF
                    System.out.print("INF\t");   // Print as "INF"
                else
                    System.out.print(A[i][j] + "\t"); // Print the distance value
            }
            System.out.println(); // New line after each row
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        // Create an instance of the class
        AllPairsShortestPathFloydWarshalls apsp = new AllPairsShortestPathFloydWarshalls();

        // Run the algorithm
        apsp.AllPairs();
    }
}
