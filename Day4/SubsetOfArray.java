//Subset Of Array
package Day4;

import java.util.Scanner;

public class SubsetOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        SubsetOfAnArray(arr);
    }

    private static void SubsetOfAnArray(int[] arr) {
        int limit = (int) Math.pow(2, arr.length);
        for (int i = 0; i < arr.length; i++) {
            String set = "";
            for (int j = arr.length - 1; j >= 0; j--) {
                int rem = i % 2;
                i = i / 2;
                if (rem == 0) {
                    set = "-" + set;
                } else {
                    set = arr[j] + set;
                }
            }
            System.out.println(set);
        }
    }
}
