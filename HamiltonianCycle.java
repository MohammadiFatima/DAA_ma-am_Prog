import java.util.*;

public class HamiltonianCycle {
    static int[][] G = {
        {0, 1, 1, 0, 1},
        {1, 0, 1, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 1, 1, 0, 1},
        {1, 0, 1, 1, 0}
    };

    static int n = G.length;
    static int[] x = new int[n + 1]; // 1-indexed

    public static void main(String[] args) {
        Arrays.fill(x, 0);
        x[1] = 1; // Start at vertex 1
        hamiltonianCycle(2);
    }

    static void hamiltonianCycle(int k) {
        while (true) {
            nextValue(k);
            if (x[k] == 0) return;

            if (k == n) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(x[i] + " ");
                }
                System.out.println(x[1]); // close cycle
            } else {
                hamiltonianCycle(k + 1);
            }
        }
    }

    static void nextValue(int k) {
        while (true) {
            x[k] = (x[k] + 1) % (n + 1); // try next vertex
            if (x[k] == 0) return; // no more vertices to try

            // check if adjacent to previous vertex
            if (G[x[k - 1] - 1][x[k] - 1] != 0) {
                int j;
                for (j = 1; j < k; j++) {
                    if (x[j] == x[k]) break; // duplicate found
                }
                if (j == k) { // no duplicate
                    if (k < n || (k == n && G[x[n] - 1][x[1] - 1] != 0)) {
                        return; // valid vertex found
                    }
                }
            }
        }
    }
}
