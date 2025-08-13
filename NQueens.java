public class NQueens {

    static int[] x;

    public static void main(String[] args) {
        int n = 5;
        x = new int[n]; 
        nQueens(0, n); 
    }

    static void nQueens(int k, int n) {
        for (int i = 0; i < n; i++) {
            if (Place(k, i)) {
                x[k] = i; 

                if (k == n - 1) {
                    printSolution(n); 
                    System.out.println("\n");
                } else {
                    nQueens(k + 1, n); 
                }
            }
        }
    }

    static boolean Place(int k, int i) {
        for (int j = 0; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false; 
            }
        }
        return true;
    }

    static void printSolution(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (x[row] != col) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" Q" + (row + 1) + " ");
                }
            }
            System.out.println("\n");
        }
    }
}

