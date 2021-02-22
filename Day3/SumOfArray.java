//Sum Of Array
package Day3;

import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int[] arr1 = new int[num1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int num2 = sc.nextInt();
        int[] arr2 = new int[num2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        sumOfArray(num1, arr1, num2, arr2);
    }

    private static void sumOfArray(int num1, int[] arr1, int num2, int[] arr2) {
        int carry = 0;
        int[] sum = new int[num1 > num2 ? num1 : num2];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        while (k >= 0) {
            int finalNumber = carry;
            if (i >= 0) {
                finalNumber += arr1[i];
            }
            if (j >= 0) {
                finalNumber += arr2[j];
            }

            carry = finalNumber / 10;
            finalNumber %= 10;
            sum[k] = finalNumber;
            i--;
            j--;
            k--;
        }
        if (carry != 0) {
            System.out.println(carry);
        }
        for (int var : sum) {
            System.out.println(var);
        }
    }
}
