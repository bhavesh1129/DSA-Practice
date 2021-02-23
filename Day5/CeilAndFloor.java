package Day5;

import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        ceilAndFloorOfAnArray(arr, k);
    }

    private static void ceilAndFloorOfAnArray(int[] arr, int k) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        int ceilValue = 0;
        int floorValue = 0;
        while (firstIndex <= lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            if (k > arr[mid]) {
                firstIndex = mid + 1;
                floorValue = arr[mid];
            } else if (k < arr[mid]) {
                lastIndex = mid - 1;
                ceilValue = arr[mid];
            } else {
                ceilValue = arr[mid];
                floorValue = arr[mid];
                break;
            }
        }
        System.out.print(ceilValue+"\n"+floorValue);
    }
}
