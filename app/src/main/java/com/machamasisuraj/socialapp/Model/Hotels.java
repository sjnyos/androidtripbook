package com.machamasisuraj.socialapp.Model;

public class Hotels {
    private String name,address,image,hotelType;

    public Hotels(String name, String address, String image, String hotelType) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.hotelType = hotelType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }
}
