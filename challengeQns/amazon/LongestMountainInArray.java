package challengeQns.amazon;

public class LongestMountainInArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(arr));
    }

    private static int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int count = 1;
            boolean flag = false;
            int j = i;
            while (j < n && arr[j] > arr[j - 1]) {
                j++;
                count++;
            }
            while (i != j && j < n && arr[j] < arr[j - 1]) {
                j++;
                flag = true;
                count++;
            }
            if (i != j && flag && count > 2) {
                res = Math.max(res, count);
                j--;
            }
            i = j;
        }
        return res;
    }
}
