package com.example.ushop.models;

public class Phone {

     String phonePrice,phoneDescription,phoneName;

    public Phone() {
    }

    public Phone(String phonePrice, String phoneDescription, String phoneName) {
        this.phonePrice = phonePrice;
        this.phoneDescription = phoneDescription;
        this.phoneName = phoneName;
    }

    public String getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(String phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }
}
