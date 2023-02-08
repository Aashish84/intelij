package org.example.vehicle;

public class Boat extends Vehicle{
    private String name;

    public Boat (){
        this.setHasWheels(false);
    }

//
//    getter and setter method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                '}';
    }
}
