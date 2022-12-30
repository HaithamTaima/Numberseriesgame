package com.example.numberseriesgame;

public class inter_data {
       private String name ;
    private  String email;
    private String password;
    private String Fill_name;
    private String date;
    private String country;
    private  boolean gender;

    public inter_data(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFill_name() {
        return Fill_name;
    }

    public void setFill_name(String fill_name) {
        Fill_name = fill_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public inter_data(String name, String email, String password, String fill_name, String date, String country, boolean gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        Fill_name = fill_name;
        this.date = date;
        this.country = country;
        this.gender = gender;
    }
}
