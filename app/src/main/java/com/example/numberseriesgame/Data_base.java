package com.example.numberseriesgame;

public class Data_base {
    private String user_name;
    private String email;
    private String password;
    private String fullName;
    private String Birthday;
    private int Country;
    private int Gender;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        user_name = user_name;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public int getCountry() {
        return Country;
    }

    public void setCountry(int country) {
        Country = country;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public Data_base(String user_name, String email, String password, String fullName,
                     String birthday, int country, int gender, String photo) {
        user_name = user_name;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        Birthday = birthday;
        Country = country;
        Gender = gender;
        Photo = photo;
    }

    private String Photo;
}
