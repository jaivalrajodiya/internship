package com.example.internship_jaival.Ui_Design;

public class Movie_Model {

    Integer imag;

    String title;

    public Movie_Model(Integer imag, String title) {
        this.imag = imag;
        this.title = title;
    }

    public Integer getImag() {
        return imag;
    }

    public void setImag(Integer imag) {
        this.imag = imag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
