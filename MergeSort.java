public class MergeSort {

    public void mergesort(int A[], int left, int right) {
        if (left < right) {
            
            int mid = (left + right) / 2;
            mergesort(A, left, mid);
            mergesort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }
    public void merge(int A[], int left, int mid, int right) {
        int i = left;      
        int j = mid + 1;    
        int k = left;    
        int B[] = new int[right + 1]; 

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

        while (i <= mid) {
            B[k] = A[i];
            i++;
            k++;
        }

        
        while (j <= right) {
            B[k] = A[j];
            j++;
            k++;
        }

        for (int x = left; x <= right; x++) {
            A[x] = B[x];
        }
    }

    public void display(int A[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        MergeSort s = new MergeSort();

        int n = 10; 
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
