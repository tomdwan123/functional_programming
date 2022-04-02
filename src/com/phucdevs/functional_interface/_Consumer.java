package com.phucdevs.functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Phuc.Le
 */
public class _Consumer {

    public static void main(String[] args) {
        // Normal java function
        Customer maria = new Customer("Maria", "12345");
        greetingCustomer(maria);
        greetingCustomerV2(maria, false);

        // Consumer Functional
        greetingCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, false);
    }

    static void greetingCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + " with phone: " + customer.getPhone());
    }

    static void greetingCustomerV2(Customer customer, boolean isShowPhone) {
        System.out.println("Hello " + customer.getName() + " "
                + (isShowPhone ? customer.getPhone() : "*****"));
    }

    static Consumer<Customer> greetingCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getName() + " with phone: " + customer.getPhone());

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, isShowPhone) ->
            System.out.println("Hello " + customer.getName() + " "
                    + (isShowPhone ? customer.getPhone() : "*****"));

    static class Customer {

        private final String name;
        private final String phone;

        Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}
