package hashset;

import java.util.*;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(subArrSum(arr, sum));
    }

    private static String subArrSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0, start = 0, end = -1;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum == sum) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currSum, i);
        }
        return end == -1 ? "Not Found" : "Found";
    }
}
