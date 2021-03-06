package com.machamasisuraj.socialapp.Model;

import java.util.Date;

public class Reservation {
    private Date startDate, endDate,pickup;
    private int travellerCount, adult,child;
    private String pickupAddress,accomodation,reservation_type,trip,user;
    private float price;

    public Reservation(Date startDate, Date endDate, Date pickup, int travellerCount,
                       int adult, int child, String pickupAddress, String accomodation,
                       String reservation_type, String trip, String user, float price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickup = pickup;
        this.travellerCount = travellerCount;
        this.adult = adult;
        this.child = child;
        this.pickupAddress = pickupAddress;
        this.accomodation = accomodation;
        this.reservation_type = reservation_type;
        this.trip = trip;
        this.user = user;
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPickup() {
        return pickup;
    }

    public void setPickup(Date pickup) {
        this.pickup = pickup;
    }

    public int getTravellerCount() {
        return travellerCount;
    }

    public void setTravellerCount(int travellerCount) {
        this.travellerCount = travellerCount;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public String getReservation_type() {
        return reservation_type;
    }

    public void setReservation_type(String reservation_type) {
        this.reservation_type = reservation_type;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
