/*
The IntQuickSorter class presented in this chapter sorts an array of int values. Create
an ObjectQuickSorter class that can sort Comparable objects. Demonstrate the class in a
program that sorts an array of String objects.
 */


import java.util.Arrays;

public class ObjectQuickSorter {

    /**
     * Swaps two elements in an array. Used by various sorting algorithms.
     *
     * @param data   the array in which the elements are swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Sorts the specified array of objects using the quicksort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the quicksort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the minimum index in the range to be sorted
     * @param max  the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
        if (min < max) {
            // create partitions
            int indexOfPartition = partition(data, min, max);

            // sort the left partition (lower values)
            quickSort(data, min, indexOfPartition - 1);

            // sort the right partition (higher values)
            quickSort(data, indexOfPartition + 1, max);
        }
    }

    /**
     * Used by the quicksort algorithm to find the partition.
     *
     * @param data the array to be sorted
     * @param min  the minimum index in the range to be sorted
     * @param max  the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
        T partitionElement;
        int left, right;
        int middle = (min + max) / 2;

        // use the middle data value as the partition element
        partitionElement = data[middle];
        // move it out of the way for now
        swap(data, middle, min);

        left = min;
        right = max;

        while (left < right) {
            // search for an element that is > the partition element
            while (left < right && data[left].compareTo(partitionElement) <= 0)
                left++;

            // search for an element that is < the partition element
            while (data[right].compareTo(partitionElement) > 0)
                right--;

            // swap the elements
            if (left < right)
                swap(data, left, right);
        }

        // move the partition element into place
        swap(data, min, right);

        return right;
    }



public static void main(String[] args) {

Integer[] arr = {55, 34, 21, 67, 87, 89, 44, 23};

System.out.println(Arrays.toString(arr));

quickSort(arr);

System.out.println(Arrays.toString(arr));

}

}