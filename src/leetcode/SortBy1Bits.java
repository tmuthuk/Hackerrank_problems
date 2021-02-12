package leetcode;

/*
    Problem Description:
    Sort Integers by The Number of 1 Bits
    Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

    Return the sorted array.

    Example 1:

    Input: arr = [0,1,2,3,4,5,6,7,8]
    Output: [0,1,2,4,8,3,5,6,7]
    Explantion: [0] is the only integer with 0 bits.
    [1,2,4,8] all have 1 bit.
    [3,5,6] have 2 bits.
    [7] has 3 bits.
    The sorted array by bits is [0,1,2,4,8,3,5,6,7]
    Example 2:

    Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
    Output: [1,2,4,8,16,32,64,128,256,512,1024]
    Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
    Example 3:

    Input: arr = [10000,10000]
    Output: [10000,10000]
    Example 4:

    Input: arr = [2,3,5,7,11,13,17,19]
    Output: [2,3,5,17,7,11,13,19]
    Example 5:

    Input: arr = [10,100,1000,10000]
    Output: [10,100,10000,1000]
 */

// Achieved Runtime 16 ms and memory 39.9 MB
public class SortBy1Bits {
    // Approach: Merge Sort + Bitwise Leftshift and count 1s

    public int[] sortByBits(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r-l) / 2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i< n1; ++i)
            L[i] = arr[l+i];

        for(int j=0; j<n2; ++j)
            R[j] = arr[m + 1 + j];

        int i =0;
        int j=0;
        int k = l;
        int shift;
        int bitCount;
        int count1;
        int count2;

        while(i < n1 && j < n2) {
            System.out.println("L["+i+"] " + L[i] + " R["+j+"]" + R[j] );
            bitCount = 0;
            shift = 1;
            count1 = 0;
            count2 = 0;
            while(bitCount < 32) {
                if((L[i] & shift) != 0) {
                    ++count1;
                }

                if((R[j] & shift) != 0) {
                    ++count2;
                }
                shift = shift << 1;

                bitCount++;
            }

            if(count1 < count2 || (count1 == count2 && L[i] <= R[j])) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i1 : arr) System.out.print(i1 + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr1);

        sort(arr1, 0, arr1.length - 1);

        System.out.println("\nSorted array");
        printArray(arr1);

        // ==

        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Given Array");
        printArray(arr2);

        sort(arr2, 0, arr2.length - 1);

        System.out.println("\nSorted array");
        printArray(arr2);

        // ==

        int[] arr3 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println("Given Array");
        printArray(arr3);

        sort(arr3, 0, arr3.length - 1);

        System.out.println("\nSorted array");
        printArray(arr3);
    }
}
