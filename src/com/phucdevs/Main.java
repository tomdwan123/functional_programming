package com.phucdevs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Phuc.Le
 */
public class Main {

    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 4, 1, 3, 7, 2, 9, 9, 4};
        List<Integer> lists = Arrays.asList(numbers);


        Set<Integer> result1 = findDuplicateByFrequency(lists);
        System.out.println("Find duplicate item by frequency: ");
        result1.forEach(System.out::println);

        Set<Integer> result2 = findDuplicateBySetAdd(lists);
        System.out.println("Find duplicate item by set add: ");
        result2.forEach(System.out::println);
    }

    static <T> Set<T> findDuplicateByFrequency(List<T> lists) {
        return lists.stream()
                .filter(l -> Collections.frequency(lists, l) > 1)
                .collect(Collectors.toSet());
    }

    static <T> Set<T> findDuplicateBySetAdd(List<T> lists) {
        Set<T> items = new HashSet<>();
        return lists.stream()
                .filter(l -> !items.add(l))
                .collect(Collectors.toSet());
    }
}
