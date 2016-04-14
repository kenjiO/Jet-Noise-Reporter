package edu.westga.jetnoisereporter.Model;


public class User {
    private String name;
    private String address;
    private String city;
    private String zipcode;
    private String phone;
    private String email;

    public User(String name, String address, String city, String zipcode, String phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.email = email;

    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getCity() {
        return this.city;
    }
    public String getZipcode() {
        return this.zipcode;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getEmail() {
        return this.email;
    }
}
