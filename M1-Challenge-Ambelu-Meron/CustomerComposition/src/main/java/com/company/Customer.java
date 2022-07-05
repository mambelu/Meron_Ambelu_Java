package com.company;

public class Customer {
    private String name;
    private String lastName;
    private Contact contact;
    private Address shippingAddress;
    private Address billingAddress;

    private boolean isRewardMember;

    public Customer(String name, String lastName, Contact contact, Address shippingAddress, Address billingAddress, boolean isRewardMember) {
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.isRewardMember = isRewardMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;

    }
    public boolean isRewardMember() {
        return isRewardMember;
    }

    public void setRewardMember(boolean rewardMember) {
        isRewardMember = rewardMember;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                ", isRewardMember=" + isRewardMember +
                '}';
    }
}

