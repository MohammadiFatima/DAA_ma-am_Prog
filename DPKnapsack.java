import java.util.ArrayList;
import java.util.List;

public class DPKnapsack {

    private static int[] profits = {1, 2, 5};        // Another sample i/p {1, 2, 5, 6}
    private static int[] weights = {2, 3, 4};        // Another sample i/p {2, 3, 4, 5}
    private static int M = 6;                        // Another sample i/p 8
    private static int n = 3;                        // Another sample i/p 4
    private static int[] x = new int[n + 1];         // Output for above sample is (0,1,0,) with profit = 8

    public static void dpknapsack() {
        int[][] tab = new int[n + 1][M + 1];

        // Initialize result array
        for (int i = 0; i < x.length; i++)
            x[i] = 0;

        // Build table using DP
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= M; w++) {
                if (weights[i - 1] <= w) {
                    int inItem = profits[i - 1] + tab[i - 1][w - weights[i - 1]];  // include item
                    int exItem = tab[i - 1][w];                                    // exclude item
                    tab[i][w] = Math.max(inItem, exItem);
                } else {
                    tab[i][w] = tab[i - 1][w];
                }
            }
        }

        // Display the DP table
        for (int[] row : tab) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }

        // Trace back included items
        List<Integer> itemsIN = new ArrayList<>();
        int w = M;
        for (int i = n; i > 0; i--) {
            if (tab[i][w] != tab[i - 1][w]) {
                itemsIN.add(i - 1);
                w -= weights[i - 1];
                x[i] = 1;
            }
        }

        // Display included items
        System.out.println("Weights included in the knapsack are:");
        for (int i = 1; i < x.length; i++)
            System.out.println("x[" + i + "] = " + x[i]);

        // Display maximum profit
        System.out.println("\nMaximum Profits value for objects placed in Knapsack = " + tab[n][M]);
    }

    public static void main(String[] args) {
        dpknapsack();
    }
}
