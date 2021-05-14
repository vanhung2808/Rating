package com.example.ratingui;

public class Rating {
    private int Image;
    private String Name;
    private int Rating;
    private String Date;
    private String Content;
    private String SeeMore;
    private String ContentSeeMore;
    private String ShopName;
    private String Reply;
    private boolean ListImage;
    private int ImageCmt1, ImageCmt2, ImageCmt3, ImageCmt4, ImageCmt5;

    public Rating(int image, String name, int rating, String date, String content, String seeMore, String shopName, String reply, boolean listImage, String contentSeeMore) {
        Image = image;
        Name = name;
        Rating = rating;
        Date = date;
        Content = content;
        SeeMore = seeMore;
        ContentSeeMore = contentSeeMore;
        ShopName = shopName;
        Reply = reply;
        ListImage = listImage;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getSeeMore() {
        return SeeMore;
    }

    public void setSeeMore(String seeMore) {
        SeeMore = seeMore;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getReply() {
        return Reply;
    }

    public void setReply(String reply) {
        Reply = reply;
    }

    public boolean isListImage() {
        return ListImage;
    }

    public void setListImage(boolean listImage) {
        ListImage = listImage;
    }

    public String getContentSeeMore() {
        return ContentSeeMore;
    }

    public void setContentSeeMore(String contentSeeMore) {
        ContentSeeMore = contentSeeMore;
    }
}
