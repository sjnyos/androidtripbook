package com.machamasisuraj.socialapp.Model;

public class BannerItem {
    private String bannerImage, title,description;

    public BannerItem(String bannerImage, String title, String description) {
        this.bannerImage = bannerImage;
        this.title = title;
        this.description = description;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
