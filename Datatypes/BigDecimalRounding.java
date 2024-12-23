package Datatypes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class BigDecimalRounding {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Number: ");
        String input  = sc.nextLine();
        BigDecimal b1 = new BigDecimal(input);
        System.out.println("Enter precision and scale");
        int precision = sc.nextInt();
        int scale = sc.nextInt();
        System.out.println("Enter Expected Number: ");
        BigDecimal expected = BigDecimal.valueOf(sc.nextDouble());
        BigDecimal rounded = b1.setScale(scale, RoundingMode.HALF_EVEN);
        if (rounded.precision() > precision) {
            System.out.println("Error: The number exceeds the allowed precision!");
            return;
        }
        System.out.println("Rounded Number: "+rounded);
        if(rounded.compareTo(expected)==0){
            System.out.println("Result Number and Expected Number match !!");
        }
        else{
            System.out.println("Result Number and Expected Number doesn't match");
        }


    }
}
