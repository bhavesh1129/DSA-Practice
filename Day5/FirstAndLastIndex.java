//First And Last Index
package Day5;

import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        firstAndLastIndexOfAnArray(arr, k);
    }

    private static void firstAndLastIndexOfAnArray(int[] arr, int k) {

    }
}
