package Day4;

import java.util.Scanner;

public class InverseOfAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        InverseOfAnArray(arr);
    }

    private static void InverseOfAnArray(int[] arr) {
        int od = 0;
        int[] newArray = new int[arr.length];
        while (od < arr.length) {
            int op = arr[od];
            int id = op;
            int ip = od;
            newArray[id] = ip;
            od++;
        }
        for (int i : newArray) {
            System.out.println(i);
        }
    }
}
