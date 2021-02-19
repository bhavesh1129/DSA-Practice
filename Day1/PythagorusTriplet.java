////Pythagorus Triplet
package Day1;

import java.util.Scanner;

public class PythagorusTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        int side3 = sc.nextInt();
        if ((side1 * side1) == (side2 * side2) + (side3 * side3) || (side2 * side2) == (side1 * side1) + (side3 * side3)
                || (side3 * side3) == (side2 * side2) + (side1 * side1)) {
                    System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
