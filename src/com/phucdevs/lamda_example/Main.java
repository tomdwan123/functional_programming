package com.phucdevs.lamda_example;

import java.util.List;

/**
 * @author Phuc.Le
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Way 1");
        System.out.println(TotalValueExample.totalValueBasic(values));
        System.out.println(TotalValueExample.totalEvenValueBasic(values));
        System.out.println(TotalValueExample.totalOddValueBasic(values));

        System.out.println("Way 2");
        System.out.println(TotalValueExample.totalValuePro(values, e -> true));
        System.out.println(TotalValueExample.totalValuePro(values, e -> e % 2 == 0));
        System.out.println(TotalValueExample.totalValuePro(values, e -> e % 2 != 0));
    }
}
