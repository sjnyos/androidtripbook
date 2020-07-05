package com.machamasisuraj.socialapp.Model;

public class TripCategories {

    private String tripName,shortName,image;

    public TripCategories(String tripName, String shortName, String image) {
        this.tripName = tripName;
        this.shortName = shortName;
        this.image = image;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
