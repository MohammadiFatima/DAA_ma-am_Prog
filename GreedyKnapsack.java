import java.util.*; 

class Item {
    int weight, profit, index;
    double ratio;
    Item(int profit, int weight, int index) {
        this.weight = weight;
        this.profit = profit;
        this.index = index;               
        this.ratio = (double) profit / weight;
    }
}

class GreedyKnapsack {

    public void Knapsack(int capacity, int n, int[] profit, int[] weight, double[] x) {

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(profit[i], weight[i], i);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        for (Item i : items) {
            System.out.println("\n" + i.weight + "  " + i.profit + "  " + i.index + "  " + i.ratio);
        }
        System.out.println("\n");

        double totalProfit = 0.0;
        double remaining = capacity;

        for (int i = 0; i < n; i++) {
            int idx = items[i].index; 

            if (items[i].weight <= remaining) {
                
                x[idx] = 1.0;
                totalProfit += items[i].profit;
                remaining -= items[i].weight;
            } else {
                
                x[idx] = remaining / items[i].weight;
                totalProfit += x[idx] * items[i].profit;
                break; 
            }
        }

        
        System.out.println("Fractions of items taken:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Item %d: %.2f\n", i + 1, x[i]);
        }

        
        System.out.printf("Maximum profit = %.2f\n", totalProfit);
    }

    public static void main(String[] args) {
        int n = 7;  
        int m = 15; 


        int[] weight = {2, 3, 5, 7, 1, 4, 1};
        int[] profit = {10, 5, 15, 7, 6, 18, 3};


        double[] x = new double[n];


        GreedyKnapsack k = new GreedyKnapsack();
        k.Knapsack(m, n, profit, weight, x);
    }
}
