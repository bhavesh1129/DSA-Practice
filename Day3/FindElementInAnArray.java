//Find Element In An Array
package Day3;

import java.util.Scanner;

public class FindElementInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        findElementsInAnArray(num, arr, k);
    }

    private static void findElementsInAnArray(int num, int[] arr, int k) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}
