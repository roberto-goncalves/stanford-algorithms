package com.stanford;

public class mergesort {

    public static void main(String[] args) {
        int[] array = {20,10,2,4,6,9, 7};
        int[] ordered = divide(array, array.length);
        for(int value: ordered){
            System.out.print(value + " ");
        }

    }

    public static int[] divide(int[] a, int n) {
        if (n < 2) {
            return a;
        }
	
	// Finding values for array divisions and creating 2 subarrays
        int mid = n / 2;
        int[] subarray_1 = new int[mid];
        int[] subarray_2 = new int[n - mid];
	
	// Filling subarrays with original array values
        for (int i = 0; i < mid; i++) {
            subarray_1[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            subarray_2[i - mid] = a[i];
        }
	// Calling recursivelly until mid and n-mid < 2, this is very important, if it has 2 or 1 element we consider that is already ordered
	// and start operations with n = 3
        divide(subarray_1, mid);
        divide(subarray_2, n - mid);
	// Merging after division
        a = merge(a, subarray_1, subarray_2, mid, n - mid);
        return a;
    }

    public static int[] merge(int[] a, int[] subarray_1, int[] subarray_2, int left, int right) {

        int i = 0, j = 0, k = 0;

        // Checking if i and j is inside array bounds
        while (i < left && j < right) {
            // Checking if we are going to use the value of subarray_1 or subarray_2 and then,
            // increment both k(result array counter) and i or j (subarrays counter)
            if (subarray_1[i] <= subarray_2[j]) {

                a[k++] = subarray_1[i++];
            }
            else {
                a[k++] = subarray_2[j++];
            }
        }
        // Assuring that i and j is at least equals to left or right and then performing operations to fill the array
        // after both operations with i and j has finished (Suggestion: use debugger to understand why)
        while (i < left) {
            a[k++] = subarray_1[i++];
        }
        while (j < right) {
            a[k++] = subarray_2[j++];
        }
        // returning a completely merged & ordered array
        return a;
    }
}
