package com.hfad.globetrotter;

public class Carrier {
    private int CarrierId;
    private String Name;

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int CarrierId) {
        this.CarrierId = CarrierId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "CarrierId=" + CarrierId +
                ", name='" + Name + '\'' +
                '}';
    }
}

