package hashset;

import java.util.HashMap;
import java.util.Scanner;

public class FindEqualNumOf1And2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        equal1And2InSubArr(arr);
    }

    private static void equal1And2InSubArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0, start = 0, end = -1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum > sum) {
                sum = currSum;
            }
            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
            }
            map.put(currSum, i);
        }
        if (end == -1) {
            System.out.println("Not found" + start + " " + end);
        } else {
            System.out.println("Found" + start + " " + end + "Sum->" + sum);
        }
    }
}
