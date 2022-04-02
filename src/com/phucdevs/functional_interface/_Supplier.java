package com.phucdevs.functional_interface;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Phuc.Le
 */
public class _Supplier {

    public static void main(String[] args) {
        System.out.println(
                "Without supplier: " +
                getDBConnectionUrl()
        );

        System.out.println(
                "With supplier: " +
                getDBConnectionUrlSupplier.get()
        );
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:3306/db_supplier";
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier = ()
            -> List.of(
                    "jdbc://localhost:3306/db_supplier1",
                    "jdbc://localhost:3306/db_supplier2"
            );
}
