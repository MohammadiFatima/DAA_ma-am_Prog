import java.util.*; 

// Class representing an item with weight, profit, index, and profit-to-weight ratio
class Item {
    int weight, profit, index;
    double ratio;

    // Constructor to initialize an item
    Item(int profit, int weight, int index) {
        this.weight = weight;             // Store weight
        this.profit = profit;             // Store profit
        this.index = index;               // Original position in input
        this.ratio = (double) profit / weight; // Calculate profit-to-weight ratio
    }
}

class GreedyKnapsack {
    
    // Method to solve the fractional knapsack problem
    public void Knapsack(int capacity, int n, int[] profit, int[] weight, double[] x) {
        
        // Step 1: Create Item objects for each input item
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(profit[i], weight[i], i);
        }

        // Step 2: Sort items by profit-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        // Step 3: Display sorted items for debugging
        for (Item i : items) {
            System.out.println("\n" + i.weight + "  " + i.profit + "  " + i.index + "  " + i.ratio);
        }
        System.out.println("\n");

        double totalProfit = 0.0; // Stores maximum profit achieved
        double remaining = capacity; // Remaining capacity of knapsack

        // Step 4: Select items greedily
        for (int i = 0; i < n; i++) {
            int idx = items[i].index; // Get original index of the item

            if (items[i].weight <= remaining) {
                // If item fits completely, take it fully
                x[idx] = 1.0;
                totalProfit += items[i].profit;
                remaining -= items[i].weight;
            } else {
                // If item doesn't fit fully, take the fraction that fits
                x[idx] = remaining / items[i].weight;
                totalProfit += x[idx] * items[i].profit;
                break; // Knapsack is full
            }
        }

        // Step 5: Output fractions of items taken
        System.out.println("Fractions of items taken:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Item %d: %.2f\n", i + 1, x[i]);
        }

        // Step 6: Output maximum profit
        System.out.printf("Maximum profit = %.2f\n", totalProfit);
    }

    // Main method to test the program
    public static void main(String[] args) {
        int n = 7;  // Number of items
        int m = 15; // Capacity of knapsack

        // Example weights and profits
        int[] weight = {2, 3, 5, 7, 1, 4, 1};
        int[] profit = {10, 5, 15, 7, 6, 18, 3};

        // Array to store fractions of each item taken
        double[] x = new double[n];

        // Create object and call knapsack method
        GreedyKnapsack k = new GreedyKnapsack();
        k.Knapsack(m, n, profit, weight, x);
    }
}
