public class QuickSort {

    public int partition(int A[], int low, int high) {
        int pivot = A[low];      // Choose the first element as pivot
        int i = low + 1;         // Pointer starting from left (after pivot)
        int j = high;            // Pointer starting from right

        // Repeat until i and j cross
        do {
            // Move i forward until we find an element greater than pivot
            while (i <= j && A[i] <= pivot) {
                i++;
            }
            // Move j backward until we find an element smaller than or equal to pivot
            while (i <= j && A[j] > pivot) {
                j--;
            }
            // Swap if valid positions found
            if (i <= j) {
                swap(A, i, j);
            }
        } while (i < j);

        // Place the pivot in its correct position
        swap(A, low, j);

        return j; // Return pivot's new index
    }

    // Recursive QuickSort function
    public void quicksort(int A[], int low, int high) {
        if (low < high) {
            int pi = partition(A, low, high); // Partition index
            quicksort(A, low, pi - 1);        // Sort left subarray
            quicksort(A, pi + 1, high);       // Sort right subarray
        }
    }

    // Utility method to swap two elements in the array
    public void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Display array elements
    public void display(int A[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    // Main method to test QuickSort
    public static void main(String args[]) {
        QuickSort s = new QuickSort();

        int n = 10;
        int A[] = new int[n];

        // Generate random numbers between 0 and 999
        for (int i = 0; i < n; i++) {
            A[i] = (int) (Math.random() * 10);
        }

        System.out.print("Original Array: ");
        s.display(A, n);

        // Perform QuickSort
        s.quicksort(A, 0, A.length - 1);

        System.out.print("Sorted Array: ");
        s.display(A, n);
    }
}
