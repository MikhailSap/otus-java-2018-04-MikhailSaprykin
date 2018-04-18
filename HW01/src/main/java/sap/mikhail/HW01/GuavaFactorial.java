package sap.mikhail.HW01;

import com.google.common.math.BigIntegerMath;
import java.util.Scanner;

public class GuavaFactorial {

    public static void main(String[] args) {
        System.out.println("If you want to see a vary big number enter 100000 or more )");
        int n = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println(BigIntegerMath.factorial(n));

    }

}
