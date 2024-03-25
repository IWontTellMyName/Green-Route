package com.example.myapplication;

public class Item
{
    String routeNo;
    int ecoScore, image;

    public Item(String routeNo, int ecoScore, int image) {
        System.out.println(ecoScore);
        this.routeNo = routeNo;
        this.ecoScore = ecoScore;
        this.image = image;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public int getEcoScore() {
        return ecoScore;
    }

    public void setEcoScore(int ecoScore) {
        this.ecoScore = ecoScore;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
