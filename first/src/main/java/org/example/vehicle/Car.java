package org.example.vehicle;

public class Car extends Vehicle{
    private String modelName;

    public Car(){
        this.setHasWheels(true);
    }

//
//    getter and setter method
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

//    to string

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                '}';
    }
}
