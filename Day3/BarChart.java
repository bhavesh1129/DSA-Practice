//Bar Chart
package Day3;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        barChart(num, arr);
    }

    private static void barChart(int num, int[] arr) {
        int maxHeight = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxHeight < arr[i]) {
                maxHeight = arr[i];
            }
        }

        for (int floor = maxHeight; floor >= 1; floor--) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= floor) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
