package com.phucdevs.functional_interface;

import java.util.function.Predicate;

/**
 * @author Phuc.Le
 */
public class _Predicate {

    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneValid("07000000000"));
        System.out.println(isPhoneValid("09000000000"));
        System.out.println(isPhoneValid("0790000000"));

        System.out.println("With predicate");
        System.out.println(isPhoneValidPredicate.test("07000000000"));
        System.out.println(isPhoneValidPredicate.test("09000000000"));
        System.out.println(isPhoneValidPredicate.test("0790000000"));

        System.out.println(
                "Is valid phone and contains number 3: " +
                isPhoneValidPredicate.and(isContainsNumber3).test("07000000000")
        );

        System.out.println(
                "Is valid phone and contains number 3: " +
                        isPhoneValidPredicate.and(isContainsNumber3).test("07000030000")
        );
    }
    
    static boolean isPhoneValid(String phone) {
        return phone.startsWith("07") && phone.length() == 11;
    }

    static Predicate<String> isPhoneValidPredicate = phone ->
            phone.startsWith("07") && phone.length() == 11;

    static  Predicate<String> isContainsNumber3 = phone ->
            phone.contains("3");
}
