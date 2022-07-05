package com.company;

public class App {
    public static void main(String[] args) {

        Address shippingAddress = new Address();
        shippingAddress.setStreet1("1234 Hope land dr.");
        shippingAddress.setCity("Atlanta");
        shippingAddress.setZip(1234);
        shippingAddress.setState("GA");

        Address billingAddress = new Address();
        shippingAddress.setStreet1("7589 Hope land dr.");
        shippingAddress.setCity("Atlanta");
        shippingAddress.setZip(4578);
        shippingAddress.setState("MD");

        Contact customerContact = new Contact();

        customerContact.setEmail("meronmeron@yahoo.com");
        customerContact.setPhoneNumber("1234-567-568");






        Customer customer1 = new Customer("Meron", "Ambelu",customerContact,shippingAddress,billingAddress,true);
        System.out.println(customer1);
    }
}
