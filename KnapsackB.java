import java.util.*;

public class KnapsackB {
    static int weights[];
    static int profits[];
    static int capacity;
    static int n; // number of items
    static int bestWeight;
    static int bestProfit;
    static int bestChoice[];

    public void soln() {
        int A[] = new int[n];
        bestProfit = 0;
        bestWeight = 0;
        bestChoice = new int[n]; // FIX: allocate bestChoice

        int combinations = (int) Math.pow(2, n);

        for (int i = 0; i < combinations; i++) {
            int tempWeight = 0;
            int tempProfit = 0;
            for (int k = 0; k < n; k++) {
                if (A[k] == 1) {
                    tempWeight += weights[k];
                    tempProfit += profits[k];
                }
            }
            if (tempWeight <= capacity && tempProfit > bestProfit) { // <= instead of <
                bestProfit = tempProfit;
                bestWeight = tempWeight;
                bestChoice = A.clone();
            }
            int j = n - 1;
            while (j >= 0 && A[j] == 1) {
                A[j] = 0;
                j--;
            }
            if (j >= 0) {
                A[j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Please Enter the number of items: ");
        n = sc.nextInt();
        System.out.println("Please Enter the Capacity of the Knapsack:");
        capacity = sc.nextInt();

        weights = new int[n];
        profits = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Please Enter the Weight associated with Item %d: ", i + 1);
            weights[i] = sc.nextInt();
            System.out.printf("Please Enter the Profit associated with Item %d: ", i + 1);
            profits[i] = sc.nextInt();
        }

        KnapsackB knapsack = new KnapsackB();
        knapsack.soln();

        System.out.println("Best total value: " + bestProfit);
        System.out.println("Best total weight: " + bestWeight);
        System.out.print("Items included (0 = no, 1 = yes): ");
        for (int i = 0; i < n; i++) {
            System.out.print(bestChoice[i] + " ");
        }
}
}