import java.util.*;

public class TSP {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        int[][] dist = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int n = dist.length;
        int N = 1 << n;  // 2^n possible subsets of cities

        int[][] dp = new int[N][n];
        int[][] prev = new int[N][n];  // To store the previous city visited for each mask

        // Initialize DP and prev arrays
        for (int[] row : dp) Arrays.fill(row, INF);
        for (int[] row : prev) Arrays.fill(row, -1);

        dp[1][0] = 0;  // Starting at city 0 with only city 0 visited

        // Fill dp and prev arrays
        for (int mask = 1; mask < N; mask++) {
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {  // if city j is in the mask
                    for (int i = 0; i < n; i++) {
                        if (i != j && (mask & (1 << i)) != 0) { // if city i is in the mask and not j
                            int prevMask = mask ^ (1 << j);
                            int newDist = dp[prevMask][i] + dist[i][j];
                            if (newDist < dp[mask][j]) {
                                dp[mask][j] = newDist;
                                prev[mask][j] = i;  // store the previous city
                            }
                        }
                    }
                }
            }
        }

        // Find minimum cost to complete the tour
        int res = INF;
        int lastCity = -1;
        for (int j = 1; j < n; j++) {
            int cost = dp[N - 1][j] + dist[j][0];
            if (cost < res) {
                res = cost;
                lastCity = j;
            }
        }

        // Print the minimum TSP cost
        System.out.println("Minimum TSP cost: " + res);

        // Reconstruct the tour path
        List<Integer> tour = new ArrayList<>();
        int mask = N - 1;  // all cities visited
        while (lastCity != -1) {
            tour.add(lastCity);
            int temp = lastCity;
            lastCity = prev[mask][lastCity];
            mask ^= (1 << temp);  // remove current city from mask
        }

        // Reverse the path to get correct order
        Collections.reverse(tour);

        // Print tour path (adding start city at the end to complete cycle)
        System.out.print("Tour path: ");
        for (int city : tour) {
            System.out.print(city + " ");
        }
        System.out.print(tour.get(0) + " ");
        System.out.println();
    }
}
