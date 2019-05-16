package com.hfad.globetrotter;

public class Airport {

    public Airport(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    private String code;
    private String name;
    private String city;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
