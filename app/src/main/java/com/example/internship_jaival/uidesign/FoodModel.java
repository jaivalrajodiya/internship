package com.example.internship_jaival.uidesign;

public class FoodModel {

    int img;

    String txt1;
    String txt2;
    String price;

    public FoodModel(int img, String txt1, String txt2, String price) {
        this.img = img;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
