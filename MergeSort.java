public class MergeSort {

    // Recursive function to perform merge sort
    public void mergesort(int A[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort the first half
            mergesort(A, left, mid);

            // Sort the second half
            mergesort(A, mid + 1, right);

            // Merge the two sorted halves
            merge(A, left, mid, right);
        }
    }

    // Function to merge two sorted subarrays into one sorted array
    public void merge(int A[], int left, int mid, int right) {
        int i = left;       // Starting index of left subarray
        int j = mid + 1;    // Starting index of right subarray
        int k = left;       // Index for the temporary array
        int B[] = new int[right + 1]; // Temporary array to hold merged result

        // Merge elements from both subarrays in sorted order
        while (i <= mid && j <= right) {
            if (A[i] < A[j]) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left subarray, if any
        while (i <= mid) {
            B[k] = A[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right subarray, if any
        while (j <= right) {
            B[k] = A[j];
            j++;
            k++;
        }

        // Copy merged elements back into the original array
        for (int x = left; x <= right; x++) {
            A[x] = B[x];
        }
    }

    // Utility function to print the array
    public void display(int A[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    // Main method to run and test MergeSort
    public static void main(String args[]) {
        MergeSort s = new MergeSort();

        int n = 10; // Size of the array to be sorted
        int A[] = new int[n];

        // Generate random array elements between 0 and 999
        for (int i = 0; i < n; i++)
            A[i] = (int) (Math.random() * 10);

        // Display the original array
        System.out.print("Original Array: ");
        s.display(A, n);
        s.mergesort(A, 0, A.length - 1);


        // Display the sorted array
        System.out.print("Sorted Array: ");
        s.display(A, n);
    }
}
