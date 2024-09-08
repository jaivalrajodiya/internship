package com.example.internship_jaival.search;

public class Serach_Model {

    String name,rollno,phoneno,email;


    public Serach_Model(String name, String rollno, String phoneno, String email) {
        this.name = name;
        this.rollno = rollno;
        this.phoneno = phoneno;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
