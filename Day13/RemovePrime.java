//Remove Primes
package Day13;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            al.add(sc.nextInt());
        }
        removePrime(al);
    }

    private static void removePrime(ArrayList<Integer> al) {
        for (int i = al.size() - 1; i >= 0; i--) {
            int value = al.get(i);
            if (isPrime(value) == true) {
                al.remove(i);
            }
        }
        System.out.print(al);
    }

    private static boolean isPrime(int value) {
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
