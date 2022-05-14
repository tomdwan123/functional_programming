package com.phucdevs.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Phuc.Le
 */
public class Main {

    public static void main(String[] args) {
        //solution("AxA", "AYA");
        //System.out.println(unConpressed("3(hi)"));
        //System.out.println(unConpressed("2(3(hi)co)"));
        //System.out.println(unConpressed("10(p)"));
        //System.out.println(unConpressed("2(2(hi)2(co))x2(bo)"));
        //sort();



        Integer x1= 256;
        int x2 = 256;
        Integer x3 = 256;
        Integer x4 = 0;
        Integer x5 = 0;
        System.out.println(x1 == x2);
        System.out.println(x1 == x3);
        System.out.println(x4 == x5);

        int num = 10;
        func(10);
        System.out.println("number is " + num);

    }

    public static String solution(String s1, String s2) {
        String answer = "";

        if (s1.length() < 1 || s1.length() > 100
            || s2.length() < 1 || s2.length() > 100) {
            return answer;
        }

        String overlappingS1 = getCombine(s1, s2);
        String overlappingS2 = getCombine(s2, s1);

        answer = overlappingS1.compareTo(overlappingS2) <= 0
                ? overlappingS1
                : overlappingS2;

        return answer;
    }

    static String getCombine(String s1, String s2) {
        int indexStartSubS1 = 0;
        int indexEndSubS1 = 0;
        int indexEndSubS2 = 0;
        String overlapping = "";

        for (int i = 0; i < s1.length(); i++) {
            indexStartSubS1 = i;
            for (int j = 0; j < s2.length(); j++) {
                if (i == s1.length()) break;

                if (s1.charAt(i) != s2.charAt(j)) {
                    if (indexEndSubS1 != s1.length() - 1)
                        overlapping = "";
                        indexEndSubS1 = 0;
                        indexEndSubS2 = 0;
                    break;
                }

                overlapping += s1.charAt(i);
                indexEndSubS1 = i;
                indexEndSubS2 = j;
                i++;
            }

            if (i == s1.length()) {
                break;
            }
        }

        String subS1 = indexEndSubS1 == s1.length() - 1
                ? s1.substring(0, indexStartSubS1)
                : s1;
        String subS2 = indexEndSubS1 == s1.length() - 1
                    ? s2.substring(indexEndSubS2 + 1)
                    : s2;

        return subS1 + overlapping + subS2;
    }

    static String unConpressed(String compressed) {
        List<Integer> numbers = new ArrayList<>();
        List<String> values = new ArrayList<>();
        int indexPrefix = 0;
        int indexOfix = 0;

        for (int i = 0; i < compressed.length(); i++) {
            if (String.valueOf(compressed.charAt(i)) == "(") {
            }
        }

        return null;
    }

    static void sort() {
        Integer[] a = {1, 4, 10, 15, 2, 45};
        List<Integer> finalList = new ArrayList<>();
        Arrays.sort(a);

        int subLength = a.length - 1;
        for (int i = a.length -1; i > subLength/2; i--) {
            finalList.add(a[i]);
            finalList.add(a[subLength - i]);
        }

        Integer[] finalArray = finalList.toArray(new Integer[finalList.size()]);
        System.out.println(finalArray);
    }

    static void func(int num) {
        num += 30;
    }

}
