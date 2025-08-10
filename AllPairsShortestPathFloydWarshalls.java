public class AllPairsShortestPathFloydWarshalls {

    int n;             
    int cost[][];       
    int A[][];         
    int INF = Integer.MAX_VALUE; 

    // Constructor to initialize the graph
    public AllPairsShortestPathFloydWarshalls() {
        n = 3;
        // INF means there is no direct edge between the vertices
        cost = new int[][]{
            {0, 4, 11},   
            {6, 0, 2},   
            {3, INF, 0}   
        };

        // Initialize A matrix (will hold intermediate shortest path results)
        A = new int[n][n];
    }

    public void AllPairs() {
        // Step 1: Initialize A with the initial cost matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = cost[i][j];

        displayA();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (A[i][k] != INF && A[k][j] != INF)
                        A[i][j] = minValue(A[i][j], A[i][k] + A[k][j]);

            System.out.println("APSP between vertices with intermediate vertex K = " + k);
            displayA();
        }
    }

    public int minValue(int x, int y) {
        return (x < y) ? x : y;
    }

    public void displayA() {
        for (int i = 0; i < n; i++) {        
            for (int j = 0; j < n; j++) {   
                if (A[i][j] == Integer.MAX_VALUE) 
                    System.out.print("INF\t"); 
                else
                    System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        AllPairsShortestPathFloydWarshalls apsp = new AllPairsShortestPathFloydWarshalls();
        apsp.AllPairs();
    }
}
