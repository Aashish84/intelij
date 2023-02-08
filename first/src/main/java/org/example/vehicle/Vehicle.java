package org.example.vehicle;

public class Vehicle {
    private String modeOfTransportation;
    private int numberOfPassangers;

//       note:  boolean datatype value is initially false
    private boolean hasWheels = true ;
    private String color;

//
//    getter and setters method
    public String getModeOfTransportation() {
        return modeOfTransportation;
    }

    public void setModeOfTransportation(String modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public void setNumberOfPassangers(int numberOfPassangers) {
        this.numberOfPassangers = numberOfPassangers;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasWheels() {
        return hasWheels;
    }

    public void setHasWheels(boolean hasWheels) {
        this.hasWheels = hasWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modeOfTransportation='" + modeOfTransportation + '\'' +
                ", numberOfPassangers=" + numberOfPassangers +
                ", hasWheels=" + hasWheels +
                ", color='" + color + '\'' +
                '}';
    }
}
