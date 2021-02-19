//Print Z Pattern
package Day1;

import java.util.*;

public class PrintZ {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int num = sc.nextInt();

      for (int i = 0; i < num; i++) {
         for (int j = 0; j < num; j++) {
            if(i==0 || i == num-1 || j == num-1-i){
               System.out.print("*");
            }else{
               System.out.print(" ");
            }
         }
         System.out.println();
      }
   }      
}
