package com.phucdevs.lamda_example;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

class Camera {

     private Function<Color, Color> filter;

     public Camera(Function<Color, Color>... filters) {
         filter = Stream.of(filters)
                 .reduce(Function.identity(), Function::andThen);
     }

     public Color snap(Color color) {
         return color;
     }

     public Color snapFilters(Color color) {
         return filter.apply(color);
     }
 }

/**
 * @author Phuc.Le
 */
public class FluentInterface {

    private static void printInt(int n,
                                 String msg,
                                 Function<Integer, Integer> func) {
        System.out.println(n + " " + msg + " " + func.apply(n));
    }

    public static void callPrintIncremented() {
        Function<Integer, Integer> inc = e -> e + 1;
        printInt(5, "incremented", inc);
    }

    public static void callPrintDoubled() {
        Function<Integer, Integer> doubled = e -> e * 2;
        printInt(5, "doubled", doubled);
    }

    public static void callPrintIncrementedAndDoubled() {
        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubled = e -> e * 2;

        printInt(5, "incremented and doubled ", inc.andThen(doubled));
    }

    public static void callPrintCamera(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void callPrintCameraMutilFilter() {
        callPrintCamera(new Camera(Color::brighter, Color::darker));
    }
}
