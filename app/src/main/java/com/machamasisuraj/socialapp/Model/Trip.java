package com.machamasisuraj.socialapp.Model;

import java.util.Date;

public class Trip {
    private String tripName, country, destination,
            itenerary, food, maproute, image, desc, grade;
    private int  duration,tripDays, size;
    private Date arrivalDate, departureDate;
    private float pricePerEach;
    private boolean receiveTransportation;

    public Trip(String tripName, String country, String destination,
                String itenerary, String food, String maproute, String image, String desc, String grade,
                int duration, int tripDays, int size, Date arrivalDate, Date departureDate,
                float pricePerEach, boolean receiveTransportation) {
        this.tripName = tripName;
        this.country = country;
        this.destination = destination;
        this.itenerary = itenerary;
        this.food = food;
        this.maproute = maproute;
        this.image = image;
        this.desc = desc;
        this.grade = grade;
        this.duration = duration;
        this.tripDays = tripDays;
        this.size = size;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.pricePerEach = pricePerEach;
        this.receiveTransportation = receiveTransportation;


    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getItenerary() {
        return itenerary;
    }

    public void setItenerary(String itenerary) {
        this.itenerary = itenerary;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMaproute() {
        return maproute;
    }

    public void setMaproute(String maproute) {
        this.maproute = maproute;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTripDays() {
        return tripDays;
    }

    public void setTripDays(int tripDays) {
        this.tripDays = tripDays;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public float getPricePerEach() {
        return pricePerEach;
    }

    public void setPricePerEach(float pricePerEach) {
        this.pricePerEach = pricePerEach;
    }

    public boolean isReceiveTransportation() {
        return receiveTransportation;
    }

    public void setReceiveTransportation(boolean receiveTransportation) {
        this.receiveTransportation = receiveTransportation;
    }


}
