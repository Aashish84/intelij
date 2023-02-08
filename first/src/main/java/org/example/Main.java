package org.example;

import org.example.vehicle.Boat;
import org.example.vehicle.Car;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println("=============");
        PrimeTask ob = new PrimeTask();
        ob.primeNum(15);

        System.out.println("=============");

        InertialTask inertialOb = new InertialTask();
        System.out.println(inertialOb.inertial(new int[] {11,4,20,9,2,8}));
        System.out.println(inertialOb.inertial(new int[] {12,11,4,9,2,3,10}));

        System.out.println("=============");

        Car car = new Car();
        car.setColor("blue");
        System.out.println(car.getColor());

        Boat boat = new Boat();
        boat.setColor("white");
        System.out.println(boat.getColor());

        System.out.println("=============");
        Container container = new Container();
        container.container(new int [] {1,8,6,2,5,4,8,3,7,7});
        container.container(new int [] {1,1});
    }
}