package heap;

import java.util.Arrays;
import java.util.Scanner;

public class heapify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildHeap(arr, n);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    private static void heapifyAlgo(int[] arr, int size, int idx) {
        int largest = idx;
        int left = 2 * size;
        int right = 2 * size + 1;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != idx) {
            swap(arr, largest, idx);
            heapifyAlgo(arr, size, largest);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        int startIdx = n / 2;
        for (int i = startIdx; i >= 0; i--) {
            heapifyAlgo(arr, n, i);
        }
//        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int v1, int v2) {
        int temp = arr[v2];
        arr[v2] = arr[v1];
        arr[v1] = temp;
    }
}
